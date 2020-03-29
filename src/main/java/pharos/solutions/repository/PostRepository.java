package pharos.solutions.repository;

import pharos.solutions.model.entity.Post;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PostRepository extends BaseRepository<Post>, JpaSpecificationExecutor<Post> {
}
