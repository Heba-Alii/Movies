package com.heba.movies.data;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MoviesClient {
    private static final String BASE_URL = "https://api.themoviedb.org/3/";
    private MoviesInterface moviesInterface;
    private static MoviesClient INSTANCE;

    public MoviesClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        moviesInterface = retrofit.create(MoviesInterface.class);
    }

    public static MoviesClient getINSTANCE() {
        if (null == INSTANCE) {
            INSTANCE = new MoviesClient();
        }
        return INSTANCE;
    }

    public MoviesInterface getMovies() {
        return moviesInterface;
    }
}
