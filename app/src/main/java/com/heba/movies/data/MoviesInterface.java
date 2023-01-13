package com.heba.movies.data;

import com.heba.movies.pojo.DetailsModel;
import com.heba.movies.pojo.GenereList;
import com.heba.movies.pojo.GenreModel;
import com.heba.movies.pojo.MovieList;
import com.heba.movies.pojo.MoviesModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MoviesInterface {
    @GET("movie/{list_id}")
    public Call<MoviesModel> getMovies();

    @GET("movie/{movie_id}")
    public Call<DetailsModel> getDetails(@Path("movie_id") int movieId);

    @GET("genre/movie/list")
    public Call<GenereList> getGenres();

    @GET("discover/movie")
    public Call<MovieList> getMoviesByGenre(@Query("with_genres") int genreId, @Query("page") int page);
}
