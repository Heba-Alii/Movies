package com.heba.movies.ui.listing;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.heba.movies.pojo.MoviesModel;

public class ListingViewModel extends ViewModel {
    MutableLiveData<MoviesModel> moviesListMutableLiveData = new MutableLiveData<>();

    public void getMovies() {

    }
}