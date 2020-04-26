package com.study.service;

import com.study.entity.Genre;
import com.study.entity.Movie;
import com.study.repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

    public void addFromFile(MultipartFile file) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
            while (reader.ready()) {
                movieRepo.save(new Movie(reader.readLine(), Integer.parseInt(reader.readLine()),
                        reader.readLine(), reader.readLine(), reader.readLine(),
                        Double.parseDouble(reader.readLine().replaceAll("rating:", "")),
                        Double.parseDouble(reader.readLine().replaceAll("price:", ""))));
                reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
