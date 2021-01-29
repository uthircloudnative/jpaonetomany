package com.gmdb.jpaonetomany.bidirectionalentymapping.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Movie {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private Integer movieRating;

    @OneToMany(mappedBy = "movie",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<UserRating> userRatings = new HashSet<>();

    public Movie() {
    }

    public Movie(String title, Integer movieRating, Set<UserRating> userRatings) {
        this.title = title;
        this.movieRating = movieRating;
        this.userRatings = userRatings;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(Integer movieRating) {
        this.movieRating = movieRating;
    }

    public Set<UserRating> getUserRatings() {
        return userRatings;
    }

    public void setUserRatings(Set<UserRating> userRatings) {
        this.userRatings = userRatings;
    }
}
