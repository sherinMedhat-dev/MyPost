package pharos.solutions.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import pharos.solutions.model.entity.Post;
import pharos.solutions.model.entity.User;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepository<User> {
    Optional<User> findByUserName(String userName);
}
