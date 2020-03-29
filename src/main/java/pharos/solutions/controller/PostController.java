package pharos.solutions.controller;

import pharos.solutions.controller.dto.PostFilterDTO;
import io.swagger.annotations.ApiOperation;
import pharos.solutions.model.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pharos.solutions.service.PostService;
import pharos.solutions.utils.SecurityUtils;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api/Posts/")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping(path = "/")
    @ApiOperation(value = "create new posts", notes = "create new post ")
    public ResponseEntity<Post> createPosts(@RequestBody @Valid PostFilterDTO postFilterDTO) {
        int userId =Integer.parseInt( SecurityUtils.getLoggedInUser());
        return ResponseEntity.ok(postService.createPosts(postFilterDTO.getContent(), postFilterDTO.getStatus(), userId));
    }

    @PostMapping(path = "/filter/")
    @ApiOperation(value = "search posts", notes = "search public posts or private posts if specifed for the current loggd in user")
    public ResponseEntity<Page<Post>> searchPosts( @RequestBody @Valid PostFilterDTO postFilterDTO, @PageableDefault Pageable pageable) {

        int userId =Integer.parseInt( SecurityUtils.getLoggedInUser());
        Page<Post> posts = postService.searchPostContents(postFilterDTO.getContent(), userId, postFilterDTO.getStatus(), pageable);

        return ResponseEntity.ok(posts);
    }
}
