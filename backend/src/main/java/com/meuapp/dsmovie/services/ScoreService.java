package com.meuapp.dsmovie.services;

import com.meuapp.dsmovie.dto.MovieDTO;
import com.meuapp.dsmovie.dto.ScoreDTO;
import com.meuapp.dsmovie.entities.Movie;
import com.meuapp.dsmovie.entities.Score;
import com.meuapp.dsmovie.entities.User;
import com.meuapp.dsmovie.repositories.MovieRepository;
import com.meuapp.dsmovie.repositories.ScoreRepository;
import com.meuapp.dsmovie.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScoreService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ScoreRepository scoreRepository;

    @Transactional
    public MovieDTO saveScore(ScoreDTO dto) {

        User user = userRepository.findByEmail(dto.getEmail());

        if (user == null) {

            user = new User();
            user.setEmail(dto.getEmail());
            user = userRepository.saveAndFlush(user);
        }

        Movie movie = movieRepository.findById(dto.getMovieId()).get();
        Score score = new Score();
        score.setMovie(movie);
        score.setUser(user);
        score.setValue(dto.getScore());
        score = scoreRepository.saveAndFlush(score);

        double sum = 0.0;
        for (Score sc : movie.getScores()) {
            sum = sum + sc.getValue();
        }

        double avg = sum / movie.getScores().size();

        movie.setScore(avg);
        movie.setCount(movie.getScores().size());
        movieRepository.save(movie);

        return new MovieDTO(movie);
    }
}
