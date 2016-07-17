package com.ycorner.totck.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Michael Yoon Huh on 7/15/2016.
 */
public final class MovieGroup {

    public final String title;
    public final List<Movies.Movie> movies;

    public MovieGroup(String title) {
        this.title = title;
        this.movies = new ArrayList<>();
    }

    public void addAll(Movies.Movie[] movies) {
        Collections.addAll(this.movies, movies);
    }

}