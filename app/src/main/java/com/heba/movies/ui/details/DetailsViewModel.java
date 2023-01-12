package com.heba.movies.ui.details;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.heba.movies.pojo.MoviesModel;

import java.util.List;

public class DetailsViewModel extends ViewModel {
    MutableLiveData<MoviesModel> postListMutableLiveData = new MutableLiveData<>();

    public void getMovies() {

    }
}