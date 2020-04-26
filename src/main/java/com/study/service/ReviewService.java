package com.study.service;

import com.study.entity.Genre;
import com.study.entity.Review;
import com.study.repository.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

    public void addFromFile(MultipartFile file) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
            while (reader.ready()) {
                reviewRepo.save(new Review(reader.readLine(), reader.readLine(), reader.readLine()));
                reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
