package com.heba.movies.ui.listing;

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
import com.heba.movies.databinding.FragmentListingBinding;

public class ListingFragment extends Fragment {

    ListingViewModel listingViewModel;
    private FragmentListingBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentListingBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        listingViewModel = ViewModelProviders.of(this).get(ListingViewModel.class);
        return root;
    }


}