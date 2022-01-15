package com.meuapp.dsmovie.services;

import com.meuapp.dsmovie.dto.MovieDTO;
import com.meuapp.dsmovie.entities.Movie;
import com.meuapp.dsmovie.repositories.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    @Transactional(readOnly = true)
    public Page<MovieDTO> findAll(Pageable pageable) {

        Page<Movie> result = repository.findAll(pageable);

        Page<MovieDTO> page = result.map(element -> new MovieDTO(element));

        return page;

    }

    @Transactional(readOnly = true)
    public MovieDTO findById(Long id) {

        Movie result = repository.findById(id).get();

        MovieDTO resultDTO = new MovieDTO(result);

        return resultDTO;

    }
}
