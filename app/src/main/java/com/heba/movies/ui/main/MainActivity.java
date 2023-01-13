package com.heba.movies.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.heba.movies.R;
import com.heba.movies.databinding.ActivityMainBinding;
import com.heba.movies.ui.listing.ListingFragment;

public class MainActivity extends AppCompatActivity {
    Fragment replaceFragment = null;
    private ActivityMainBinding binding;
    private FragmentManager manager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        manager = getSupportFragmentManager();
        replaceFragment = new ListingFragment();
        manager.beginTransaction().replace(R.id.fragmentContainerView, replaceFragment).commit();


    }
}