package com.heba.movies.data;

import androidx.annotation.NonNull;

import com.heba.movies.BuildConfig;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import okhttp3.OkHttpClient;
import retrofit2.converter.gson.GsonConverterFactory;

public class MoviesClient {
    private static final String BASE_URL = "https://api.themoviedb.org/3/";
    private MoviesInterface moviesInterface;
    private static MoviesClient INSTANCE;
    private static final String QUERY_LANGUAGE = "en";
    private static final String IMAGE_LANGUAGE = "en,null";


    public MoviesClient() {
        OkHttpClient okClient = new OkHttpClient.Builder()
                .addInterceptor(
                        new Interceptor() {
                            @Override
                            public Response intercept(Interceptor.Chain chain) throws IOException {
                                Request originalRequest = chain.request();
                                HttpUrl originalUrl = originalRequest.url();
                                HttpUrl url = originalUrl.newBuilder()
                                        .addQueryParameter("api_key", "112e4a60455675fcc2e069b755f8e1bf")
                                        .addQueryParameter("language", QUERY_LANGUAGE)
                                        .addQueryParameter("include_image_language", IMAGE_LANGUAGE)
                                        .build();
                                Request.Builder requestBuilder = originalRequest.newBuilder().url(url);
                                Request request = requestBuilder.build();
                                return chain.proceed(request);
                            }
                        })
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okClient)
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
