package com.study.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.study.entity.Genre;
import com.study.repository.GenreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

@Service
public class GenreService {

    @Autowired
    private GenreRepo genreRepo;

    public Iterable findAll() {
        return genreRepo.findAll();
    }

    public Genre save(Genre genre) {
        return genreRepo.save(genre);
    }

    public void deleteById(int id) {
        genreRepo.deleteById(id);
    }

    public void deleteAll() {
        genreRepo.deleteAll();
    }

    public Genre findById(int id) {
        return genreRepo.findById(id).get();
    }

    public void addFromFile(MultipartFile file) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
            while (reader.ready()) {
                genreRepo.save(new Genre(reader.readLine()));
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addFromJSON(MultipartFile file) {
        try {
            InputStreamReader reader = new InputStreamReader(file.getInputStream());
            List<Genre> list = Arrays.asList(new Gson().fromJson(reader, Genre[].class));
            genreRepo.saveAll(list);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
