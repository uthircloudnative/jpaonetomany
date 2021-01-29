package com.gmdb.jpaonetomany.bidirectionalentymapping.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gmdb.jpaonetomany.bidirectionalentymapping.entity.Movie;
import com.gmdb.jpaonetomany.bidirectionalentymapping.entity.UserRating;
import com.gmdb.jpaonetomany.bidirectionalentymapping.repository.MovieRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class JpaOneToManyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void init(){
        movieRepository.deleteAll();
    }

    @Test
    void testPostJpaOneToMany() throws Exception {

        UserRating userRating = new UserRating(Integer.valueOf("8"),"James");

        Set<UserRating> userRatingSet = new HashSet<>();
        userRatingSet.add(userRating);

        Movie movie = new Movie("Titanic", Integer.valueOf("8"), new HashSet<UserRating>(userRatingSet));

        mockMvc.perform(MockMvcRequestBuilders.post("/movie")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(movie))).andExpect(status().isCreated());
    }

    @Test
    void testGetJpaOneToMany() throws Exception {

        UserRating userRating = new UserRating();

        userRating.setRating(Integer.valueOf("8"));
        userRating.setRatedBy("James");

        List<Movie> movies = new ArrayList<>();

        Movie movie = new Movie();

        movie.setMovieRating(Integer.valueOf("8"));
        movie.setTitle("Titanic");
        userRating.setMovie(movie);

        movie.getUserRatings().add(userRating);

        movies.add(movie);

        movieRepository.save(movie);

        System.out.println(objectMapper.writeValueAsString(movies));

        mockMvc.perform(MockMvcRequestBuilders.get("/movie"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(movies)))
                .andDo(print());
    }


}
