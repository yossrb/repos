package com.esprit.microservices.post.Controller;

import com.esprit.microservices.post.Entity.Post;
import com.esprit.microservices.post.Entity.Review;
import com.esprit.microservices.post.Repository.ReviewRepository;
import com.esprit.microservices.post.services.PostServices;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@CrossOrigin(origins="*")
@RequestMapping("/posts")

@RestController
@AllArgsConstructor
public class PostController {
    @Autowired
    PostServices ps;

    @Autowired
    private ReviewRepository Revrep;

    //http://localhost:8085/trotti/post/swagger-ui/index.html
    @GetMapping({"/GetAllPost"})
    public List<Post> GetAllPost(){
        return ps.GetAllPost();
    }


    @PostMapping({"/AddPost/{id}"})
    public Post AddPost(@RequestBody Post post,@PathVariable("id") int id) {
        return ps.addPostToReview(post,id);
    }

    @PutMapping("/UpdatePost/{id}")
    @ResponseBody
    public Post UpdatePost(@RequestBody Post post,@PathVariable("id") int id) {
        return ps.UpdatePost(post,id);
    }

    @DeleteMapping("/DeletePost/{id}")
    @ResponseBody
    public void DeletePost(@PathVariable("id") int id) {
        ps.DeletePost(id);
    }

    @GetMapping({"/Getpost/{id}"})
    public Post Getpost(@PathVariable("id") Integer id){
        return ps.retrievePost(id);
    }


    @GetMapping("/retrievePostsOfReview/{id}")
    public Set<Post> retrievePostsOfReview(@PathVariable Integer id) {
        Review r = Revrep.findById(id).orElse(null);
        if (r != null) {
            return r.getPosts();
        } else {
            return null;
        }
    }

}