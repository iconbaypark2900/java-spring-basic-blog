package com.pluralsight.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.ModelMap;
import com.pluralsight.blog.data.PostRepository;
import com.pluralsight.blog.model.Post;

import java.util.List;

@Controller
public class BlogController {

    private PostRepository postRepository;

    public BlogController(PostRepository postRepository) {
        this.postRepository = postRepository;    
    }

    @RequestMapping("/")
    public String listPosts(ModelMap modelMap) {
        List<Post> posts = postRepository.getAllPosts();
        modelMap.put("posts", posts);
        return "home";
    }

    
}
