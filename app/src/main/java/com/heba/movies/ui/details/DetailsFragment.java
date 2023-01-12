package com.heba.movies.ui.details;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.heba.movies.R;
import com.heba.movies.databinding.FragmentDetailsBinding;
import com.heba.movies.pojo.MoviesModel;

public class DetailsFragment extends Fragment {

    DetailsViewModel detailsViewModel;
    private FragmentDetailsBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentDetailsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        // return inflater.inflate(R.layout.fragment_details, container, false);
        detailsViewModel = ViewModelProviders.of(this).get(DetailsViewModel.class);
        detailsViewModel.movieListMutableLiveData.observe(this, new Observer<MoviesModel>() {
            @Override
            public void onChanged(MoviesModel moviesModel) {
                binding.movieTitle.setText(moviesModel.getTitle());
                binding.movieDetailsYearProduction.setText(moviesModel.getReleaseDate());
                binding.movieDesc.setText(moviesModel.getOverview());
            }
        });
        return root;
    }

}