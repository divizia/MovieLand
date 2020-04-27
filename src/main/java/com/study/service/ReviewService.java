package com.study.service;

import com.google.gson.Gson;
import com.study.entity.Genre;
import com.study.entity.Review;
import com.study.repository.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

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

    public void addFromJSON(MultipartFile file) {
        try {
            InputStreamReader reader = new InputStreamReader(file.getInputStream());
            List<Review> list = Arrays.asList(new Gson().fromJson(reader, Review[].class));
            reviewRepo.saveAll(list);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
