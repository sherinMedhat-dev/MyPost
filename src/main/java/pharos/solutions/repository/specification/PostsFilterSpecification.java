package pharos.solutions.repository.specification;

import com.google.common.base.Splitter;
import pharos.solutions.model.entity.Post;
import pharos.solutions.model.enums.PostStatus;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.CollectionUtils;

import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import java.util.List;
import java.util.stream.Collectors;

public class PostsFilterSpecification {
    public static Specification<Post> containsAllContentPartsOrIgnoreIfNull(String content) {
        List<String> contentTokens = splitTextToTokens(content.toLowerCase());
        return (root, query, cb) -> {
            if (CollectionUtils.isEmpty(contentTokens)) return null;

            Predicate contentFilter = cb.conjunction();
            for (String contentToken : contentTokens) {
                contentFilter = cb.and(contentFilter, cb.like(cb.lower(root.get("content")), "%" + contentToken + "%"));
            }

            return contentFilter;
        };

    }

    public static Specification<Post> hasPublicPostStatus(){
        return (root, query, cb) -> cb.equal(root.get("Status"), PostStatus.publicPost) ;
    }
    public static Specification<Post> hasPrivatePostStatus(){
        return (root, query, cb) -> cb.equal(root.get("Status"), PostStatus.privatePost)  ;
    }

    public static Specification<Post> withCurrentUser(int userId) {
        return (root, query, cb) -> cb.equal(root.join("creator", JoinType.INNER).get("id"), userId);


    }
    public static Specification<Post> orderCreationDate() {
        return (root, query, cb) -> {
            query.orderBy(cb.desc(root.get("createdAt")));
            return  null;
        };

    }
// query.orderBy(cb.desc(root.get("createdAt")));

    private static List<String> splitTextToTokens(String content) {
        Splitter timerSplitter = Splitter.on(" ").omitEmptyStrings().trimResults();
        return timerSplitter.splitToList(content).stream().distinct().collect(Collectors.toList());
    }
}
