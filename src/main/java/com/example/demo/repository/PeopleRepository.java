package com.example.demo.repository;

import com.example.demo.domain.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Spring Data JPA repository for the People entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PeopleRepository extends JpaRepository<People,Long> {

    @Query("select distinct p.sex from People p")
    List<String> findDistinctSex();

    Long countBySex(String sex);

}
