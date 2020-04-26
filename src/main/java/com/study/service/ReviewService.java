package com.study.service;

import com.study.entity.Review;
import com.study.repository.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepo reviewRepo;

    public Iterable findAll() {
        return reviewRepo.findAll();
    }

    public Review save(Review review) {
        return reviewRepo.save(review);
    }

    public void deleteById(int id) {
        reviewRepo.deleteById(id);
    }

    public void deleteAll() {
        reviewRepo.deleteAll();
    }

    public Review findById(int id) {
        return reviewRepo.findById(id).get();
    }
}
