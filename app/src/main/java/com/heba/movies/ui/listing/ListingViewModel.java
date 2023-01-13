package com.heba.movies.ui.listing;

import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.heba.movies.data.MoviesClient;
import com.heba.movies.pojo.GenreModel;
import com.heba.movies.pojo.MoviesModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListingViewModel extends ViewModel {
    MutableLiveData<MoviesModel> moviesListMutableLiveData = new MutableLiveData<>();
    MutableLiveData<GenreModel> genreMutableLiveData = new MutableLiveData<>();

    public void getGenres() {
        Call<GenreModel> call = MoviesClient.getINSTANCE().getMovies().getGenres();
        call.enqueue(new Callback<GenreModel>() {
            @Override
            public void onResponse(Call<GenreModel> call, Response<GenreModel> response) {

                genreMutableLiveData.setValue(response.body());

            }

            @Override
            public void onFailure(Call<GenreModel> call, Throwable t) {
                Log.d("TAG", "onResponse: not success" + t.getMessage());

            }
        });
    }
}