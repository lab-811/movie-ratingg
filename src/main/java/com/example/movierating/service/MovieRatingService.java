package com.example.movierating.service;

import com.example.movierating.model.Rating;
import com.example.movierating.repository.MovieRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieRatingService {

    @Autowired
    private MovieRatingRepository repository;

    public Optional<Rating> getMovieRating(Long movieId) {
        return repository.findById(movieId);
    }

    public List<Rating> getRatings() {
        return repository.findAll();
    }
}
