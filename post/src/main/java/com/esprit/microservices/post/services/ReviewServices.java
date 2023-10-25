package com.esprit.microservices.post.services;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import com.esprit.microservices.post.Entity.Review;
import com.esprit.microservices.post.Repository.ReviewRepository;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.util.List;

@Service
public class ReviewServices {
    @Autowired
    ServletContext context;
    @Autowired
    private ReviewRepository rp;

    public List<Review> GetAllReviews(){
        return rp.findAll();
    }

    public Review addReview(Review review){
        return rp.save(review);
    }

    public Review updateReview(int id, Review updateRev ){
        Review existingReview=rp.findById(id).orElse(null);
        if (existingReview!=null){
            existingReview.setTitre(updateRev.getTitre());
            existingReview.setDescription(updateRev.getDescription());
        }
        return rp.save(existingReview);
    }

    public void deleteReview(long id) {
        rp.deleteById((int) id);
    }

    public Review retrieveReview(int id) {
        return rp.findById(id).orElse(null);
    }


}