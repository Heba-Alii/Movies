package com.heba.movies.ui.listing;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.heba.movies.R;
import com.heba.movies.databinding.FragmentDetailsBinding;
import com.heba.movies.databinding.FragmentListingBinding;
import com.heba.movies.pojo.GenreModel;
import com.heba.movies.pojo.MoviesModel;

public class ListingFragment extends Fragment {

    ListingViewModel listingViewModel;
    private FragmentListingBinding binding;
    private TabLayout tabLayout;
    private MovieListingAdapter movieListingAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentListingBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        listingViewModel = ViewModelProviders.of(this).get(ListingViewModel.class);
        listingViewModel.getGenres();
        MovieListingAdapter movieListingAdapter = new MovieListingAdapter();
        binding.listingRecycler.setAdapter(movieListingAdapter);
        listingViewModel.genreMutableLiveData.observe(this, new Observer<GenreModel>() {
            @Override
            public void onChanged(GenreModel genreModel) {
                binding.moviesTab.addTab(binding.moviesTab.newTab().setText(genreModel.getName()));


            }
        });
        initView();
        return root;
    }

    public void initView() {
        binding.moviesTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                binding.listingRecycler.scrollToPosition(tab.getPosition());
                tab.select();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

}