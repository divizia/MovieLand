package com.study.repository;

import com.study.entity.User1;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User1, Integer> {

}
