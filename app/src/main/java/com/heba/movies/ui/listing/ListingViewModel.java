package com.heba.movies.ui.listing;

import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.heba.movies.data.MoviesClient;
import com.heba.movies.pojo.GenereList;
import com.heba.movies.pojo.GenreModel;
import com.heba.movies.pojo.MovieList;
import com.heba.movies.pojo.MoviesModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListingViewModel extends ViewModel {
    MutableLiveData<MovieList> moviesListMutableLiveData = new MutableLiveData<>();
    MutableLiveData<GenereList> genreMutableLiveData = new MutableLiveData<>();

    public void getGenres() {
        Call<GenereList> call = MoviesClient.getINSTANCE().getMovies().getGenres();
        call.enqueue(new Callback<GenereList>() {
            @Override
            public void onResponse(Call<GenereList> call, Response<GenereList> response) {
                genreMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<GenereList> call, Throwable t) {
                Log.d("TAG", "onResponse: not success" + t.getMessage());

            }
        });
    }

    public void getMoviesByGenre(int genreId) {
        Call<MovieList> call = MoviesClient.getINSTANCE().getMovies().getMoviesByGenre(genreId, 1);
        call.enqueue(new Callback<MovieList>() {
            @Override
            public void onResponse(Call<MovieList> call, Response<MovieList> response) {
                moviesListMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<MovieList> call, Throwable t) {
                Log.d("TAG", "onResponse: not success" + t.getMessage());
            }
        });
    }
}