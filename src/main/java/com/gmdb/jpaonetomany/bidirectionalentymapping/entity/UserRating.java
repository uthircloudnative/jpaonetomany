package com.gmdb.jpaonetomany.bidirectionalentymapping.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class UserRating {

    @Id
    @GeneratedValue
    private Long id;

    private Integer rating;
    private String ratedBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id",nullable = false)
    @JsonBackReference
    private Movie movie;

    public UserRating() {
    }

    public UserRating(Integer rating, String ratedBy) {
        this.rating = rating;
        this.ratedBy = ratedBy;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getRatedBy() {
        return ratedBy;
    }

    public void setRatedBy(String ratedBy) {
        this.ratedBy = ratedBy;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
