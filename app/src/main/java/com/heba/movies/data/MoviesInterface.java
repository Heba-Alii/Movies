package com.heba.movies.data;

import com.heba.movies.pojo.MoviesModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MoviesInterface {
    @GET("movie/{list_id}")
    public Call<MoviesModel> getMovies();
}
