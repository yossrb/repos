package com.esprit.microservices.post.Controller;


import com.esprit.microservices.post.Entity.Review;

import com.esprit.microservices.post.services.ReviewServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;




@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewServices reviewServices;

    @GetMapping("/getAllReviews")
    public List<Review> getAllReviews() {
        return reviewServices.GetAllReviews();
    }

    @GetMapping("/GetReviwByID/{id}")
    public Review getReviewById(@PathVariable int id) {
        return reviewServices.retrieveReview(id);
    }

    @PostMapping("/addReview")
    public Review addReview(@RequestBody Review review) {
        return reviewServices.addReview(review);
    }

    @PutMapping("updateReview/{id}")
    public Review updateReview(@PathVariable int id, @RequestBody Review updatedReview) {
        return reviewServices.updateReview(id, updatedReview);
    }

    @DeleteMapping("deleteReview/{id}")
    public void deleteReview(@PathVariable long id) {
        reviewServices.deleteReview(id);
    }
}