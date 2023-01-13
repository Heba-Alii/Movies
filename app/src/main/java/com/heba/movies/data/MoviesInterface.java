package com.heba.movies.data;

import com.heba.movies.pojo.DetailsModel;
import com.heba.movies.pojo.GenreModel;
import com.heba.movies.pojo.MoviesModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MoviesInterface {
    @GET("movie/{list_id}")
    public Call<MoviesModel> getMovies();

    @GET("genre/movie/list")
    public Call<GenreModel> getGenres();

    @GET("movie/{movie_id")
    public Call<DetailsModel> getDetails(@Path("movie_id") int movieId);
}
