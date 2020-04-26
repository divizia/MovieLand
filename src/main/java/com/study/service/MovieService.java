package com.study.service;

import com.study.entity.Movie;
import com.study.repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    private MovieRepo movieRepo;

    public Iterable findAll() {
        return movieRepo.findAll();
    }

    public Movie save(Movie movie) {
        return movieRepo.save(movie);
    }

    public void deleteById(int id) {
        movieRepo.deleteById(id);
    }

    public void deleteAll() {
        movieRepo.deleteAll();
    }

    public Movie findById(int id) {
        return movieRepo.findById(id).get();
    }
}
