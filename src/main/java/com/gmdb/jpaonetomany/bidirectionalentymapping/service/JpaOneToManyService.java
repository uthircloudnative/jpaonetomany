package com.gmdb.jpaonetomany.bidirectionalentymapping.service;

import com.gmdb.jpaonetomany.bidirectionalentymapping.entity.Movie;

import java.util.List;

public interface JpaOneToManyService {

    void createMovie(Movie movie);

    List<Movie> getAllMovies();
}
