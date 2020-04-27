package com.study.service;

import com.google.gson.Gson;
import com.study.entity.Genre;
import com.study.entity.User1;
import com.study.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public Iterable findAll() {
        return userRepo.findAll();
    }

    public User1 save(User1 user) {
        return userRepo.save(user);
    }

    public void deleteById(int id) {
        userRepo.deleteById(id);
    }

    public void deleteAll() {
        userRepo.deleteAll();
    }

    public User1 findById(int id) {
        return userRepo.findById(id).get();
    }

    public void addFromFile(MultipartFile file) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
            while (reader.ready()) {
                userRepo.save(new User1(reader.readLine(), reader.readLine(), reader.readLine()));
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
            List<User1> list = Arrays.asList(new Gson().fromJson(reader, User1[].class));
            userRepo.saveAll(list);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
