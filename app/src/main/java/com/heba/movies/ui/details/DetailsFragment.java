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

import com.bumptech.glide.Glide;
import com.heba.movies.R;
import com.heba.movies.databinding.FragmentDetailsBinding;
import com.heba.movies.pojo.DetailsModel;
import com.heba.movies.pojo.MoviesModel;

public class DetailsFragment extends Fragment {

    DetailsViewModel detailsViewModel;
    private FragmentDetailsBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = FragmentDetailsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        detailsViewModel = ViewModelProviders.of(this).get(DetailsViewModel.class);
        int moviesId = getArguments().getInt("movieId");
        detailsViewModel.getMoviesDetails(moviesId);
        detailsViewModel.detailsModelMutableLiveData.observe(this, new Observer<DetailsModel>() {
            @Override
            public void onChanged(DetailsModel detailsModel) {
                movieImage(detailsModel.getPoster_path());
                binding.ratingBar.setRating(detailsModel.getVote_average());
                binding.setMovieDetails(detailsModel);
            }
        });
        return root;
    }
    public void movieImage(String url) {
        Glide.with(this)
                .load(url)
                .fitCenter()
                .into(binding.imgDetails);
    }
}