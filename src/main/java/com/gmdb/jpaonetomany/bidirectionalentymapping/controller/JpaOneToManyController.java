package com.gmdb.jpaonetomany.bidirectionalentymapping.controller;

import com.gmdb.jpaonetomany.bidirectionalentymapping.entity.Movie;
import com.gmdb.jpaonetomany.bidirectionalentymapping.service.JpaOneToManyService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JpaOneToManyController {

    private JpaOneToManyService jpaOneToManyService;

    public JpaOneToManyController(JpaOneToManyService jpaOneToManyService) {
        this.jpaOneToManyService = jpaOneToManyService;
    }

    @GetMapping("/movie")
    @ResponseStatus(HttpStatus.OK)
    public List<Movie> getAllMovies(){
        return jpaOneToManyService.getAllMovies();
    }

    @PostMapping("/movie")
    @ResponseStatus(HttpStatus.CREATED)
    public void createMovieRating(@RequestBody Movie movie){
        jpaOneToManyService.createMovie(movie);
    }


}
