package com.study.service;

import com.study.entity.User1;
import com.study.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
