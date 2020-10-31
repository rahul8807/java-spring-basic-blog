package com.pluralsight.blog;

import com.pluralsight.blog.model.Post;
import com.pluralsight.blog.data.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BlogController {

    private PostRepository postRepository;

    public BlogController(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    @RequestMapping("/post/{id}")
    public String postDetails(@PathVariable Long id,ModelMap modelMap){
        modelMap.put("post",postRepository.findById(id)) ;
        return "post-details";
    }

    @RequestMapping("/")
    public String listPosts(ModelMap modelMap){
        List<Post> postList = postRepository.getAllPosts();
        modelMap.put("posts",postList);
        modelMap.put("title","Blog Post 1");
        return "home";
    }
}
