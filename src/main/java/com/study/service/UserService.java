package com.study.service;

import com.study.entity.User1;
import com.study.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
}
