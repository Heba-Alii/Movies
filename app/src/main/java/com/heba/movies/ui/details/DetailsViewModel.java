package com.heba.movies.ui.details;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.heba.movies.data.MoviesClient;
import com.heba.movies.pojo.DetailsModel;
import com.heba.movies.pojo.GenreModel;
import com.heba.movies.pojo.MoviesModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailsViewModel extends ViewModel {
    MutableLiveData<DetailsModel> detailsModelMutableLiveData = new MutableLiveData<>();

    public void getMoviesDetails(int movieId) {
        Call<DetailsModel> call = MoviesClient.getINSTANCE().getMovies().getDetails(movieId);
        call.enqueue(new Callback<DetailsModel>() {
            @Override
            public void onResponse(Call<DetailsModel> call, Response<DetailsModel> response) {

                detailsModelMutableLiveData.setValue(response.body());

            }

            @Override
            public void onFailure(Call<DetailsModel> call, Throwable t) {
                Log.d("TAG", "onResponse: not success" + t.getMessage());

            }
        });

    }
}