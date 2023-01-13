package com.heba.movies.ui.listing;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.tabs.TabLayout;
import com.heba.movies.databinding.FragmentListingBinding;
import com.heba.movies.pojo.GenereList;
import com.heba.movies.pojo.MovieList;

import java.util.Objects;

public class ListingFragment extends Fragment {
    ListingViewModel listingViewModel;
    private FragmentListingBinding binding;
    private MovieListingAdapter movieListingAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentListingBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        listingViewModel = ViewModelProviders.of(this).get(ListingViewModel.class);
        listingViewModel.getGenres();
        movieListingAdapter = new MovieListingAdapter();
        binding.listingRecycler.setAdapter(movieListingAdapter);
        listingViewModel.genreMutableLiveData.observe(getViewLifecycleOwner(), new Observer<GenereList>() {
            @Override
            public void onChanged(GenereList genreList) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    genreList.getGenres().forEach(genreModel -> {
                        binding.moviesTab.addTab(binding.moviesTab.newTab().setText(genreModel.getName()));
                    });
                }

            }
        });
        listingViewModel.moviesListMutableLiveData.observe(getViewLifecycleOwner(), new Observer<MovieList>() {
            @Override
            public void onChanged(MovieList movieList) {
                movieListingAdapter.setList(movieList.getResults());
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
                listingViewModel.getMoviesByGenre(Objects.requireNonNull(listingViewModel.genreMutableLiveData.getValue()).getGenres().get(tab.getPosition()).getId());
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