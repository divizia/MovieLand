package com.study.repository;

import com.study.entity.Review;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepo extends CrudRepository<Review, Integer> {

}
