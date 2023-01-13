package com.heba.movies.pojo;

import java.io.Serializable;
import java.util.ArrayList;

public class MovieList implements Serializable {
    private ArrayList<MoviesModel> results;

    public ArrayList<MoviesModel> getResults() {
        return results;
    }

    public void setResults(ArrayList<MoviesModel> results) {
        this.results = results;
    }

}
