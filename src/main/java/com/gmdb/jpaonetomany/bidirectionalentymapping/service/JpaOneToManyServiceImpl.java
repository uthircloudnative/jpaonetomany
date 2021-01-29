package com.gmdb.jpaonetomany.bidirectionalentymapping.service;

import com.gmdb.jpaonetomany.bidirectionalentymapping.entity.Movie;
import com.gmdb.jpaonetomany.bidirectionalentymapping.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JpaOneToManyServiceImpl implements JpaOneToManyService {

    private MovieRepository movieRepository;

    public JpaOneToManyServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void createMovie(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
}
