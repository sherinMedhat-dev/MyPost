package pharos.solutions.service;

import pharos.solutions.model.entity.Post;
import pharos.solutions.model.enums.PostStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostService {
    Post createPosts(String content, PostStatus postStatus, int creatorId);
    Page<Post> searchPostContents(String content, int userId , PostStatus postStatus, Pageable pageable);
}
