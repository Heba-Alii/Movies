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
        listingViewModel.getMovies();
        MovieListingAdapter movieListingAdapter = new MovieListingAdapter();
        binding.listingRecycler.setAdapter(movieListingAdapter);
        listingViewModel.moviesListMutableLiveData.observe(this, new Observer<MoviesModel>() {
            @Override
            public void onChanged(MoviesModel moviesModel) {

                binding.listingRecycler.setAdapter(movieListingAdapter);
                int index=getArguments().getInt("index");

            }
        });
        initView();
        return root;
    }

    public void initView() {
        binding.listingRecycler.addOnChildAttachStateChangeListener(new TabLayout.TabLayoutOnPageChangeListener(binding.moviesTab));
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