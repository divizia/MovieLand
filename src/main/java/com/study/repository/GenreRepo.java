package com.study.repository;

import com.study.entity.Genre;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface GenreRepo extends CrudRepository<Genre, Integer> {
    /* @Query("from Message p where p.text = ?1")
    List<Message> findByTag(String tag);*/

  //  @Query("from Genre g where g.id = ?1")
  //  void deleteByLong(Long id);

}
