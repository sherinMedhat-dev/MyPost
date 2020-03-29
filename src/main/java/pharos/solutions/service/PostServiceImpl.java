package pharos.solutions.service;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import pharos.solutions.model.entity.Post;
import pharos.solutions.model.entity.User;
import pharos.solutions.model.enums.PostStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pharos.solutions.repository.PostRepository;
import pharos.solutions.repository.UserRepository;
import pharos.solutions.repository.specification.PostsFilterSpecification;

import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Post createPosts(String content, PostStatus postStatus, int creatorId) {
        Optional<User> user = userRepository.findById(creatorId);
        if (!user.isPresent()) {
            throw new RuntimeException("not valid ");
        }
        Post post = new Post(content, postStatus, user.get());
        return postRepository.save(post);
    }

    @Override
    public Page<Post> searchPostContents(String content, int userId, PostStatus postStatus, Pageable pageable) {
        if (userId == 0) {
            throw new RuntimeException("no specified user");
        }

        if (postStatus == PostStatus.publicPost) {
            return postRepository.findAll(Specification
                    .where(PostsFilterSpecification.containsAllContentPartsOrIgnoreIfNull(content))
                    .and(PostsFilterSpecification.hasPublicPostStatus())
                    .and(PostsFilterSpecification.orderCreationDate()), pageable);
        } else {
            return postRepository.findAll(Specification
                    .where(PostsFilterSpecification.containsAllContentPartsOrIgnoreIfNull(content))
                    .and(PostsFilterSpecification.hasPrivatePostStatus())
                    .and(PostsFilterSpecification.withCurrentUser(userId))
                    .and(PostsFilterSpecification.orderCreationDate()), pageable);
        }


    }
}
