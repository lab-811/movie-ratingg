package com.example.movierating.controller;

import com.example.movierating.model.Rating;
import com.example.movierating.service.MovieRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movie/ratings")
public class MovieRatingController {

    @Autowired
    private MovieRatingService service;

    private static final String TOPIC = "movie_rating";

    @Autowired
    private KafkaTemplate<String, Optional<Rating>> kafkaTemplate;

    @GetMapping
    public List<Rating> getRatings() {
        return  service.getRatings();
    }



    @GetMapping("/{movieId}")
    public Optional<Rating> getMovieRating(@PathVariable("movieId") Long movieId) {

        kafkaTemplate.send(TOPIC, service.getMovieRating(movieId));
        return  service.getMovieRating(movieId);
    }



}
