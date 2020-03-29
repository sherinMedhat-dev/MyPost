package pharos.solutions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import pharos.solutions.ExceptionHandler.ExceptionHandler;

@SpringBootApplication
@Import(ExceptionHandler.class)
public class PostsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PostsServiceApplication.class, args);
    }
}
