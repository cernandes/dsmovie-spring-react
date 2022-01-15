package com.meuapp.dsmovie.repositories;

import com.meuapp.dsmovie.entities.Movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

}
