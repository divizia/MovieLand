package com.study.repository;

import com.study.entity.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepo extends CrudRepository<Movie, Integer> {

}
