package com.meuapp.dsmovie.repositories;

import com.meuapp.dsmovie.entities.Score;
import com.meuapp.dsmovie.entities.ScorePK;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends JpaRepository<Score, ScorePK> {

}
