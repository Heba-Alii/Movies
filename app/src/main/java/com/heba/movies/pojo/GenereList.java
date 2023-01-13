package com.heba.movies.pojo;

import java.io.Serializable;
import java.util.List;

public class GenereList implements Serializable {
    private List<GenreModel> genres;

    public List<GenreModel> getGenres() {
        return genres;
    }

    public void setGenres(List<GenreModel> genres) {
        this.genres = genres;
    }
}
