package com.heba.movies.ui.listing;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.heba.movies.R;
import com.heba.movies.pojo.MoviesModel;
import com.heba.movies.ui.details.DetailsFragment;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

//import eg.gov.iti.recyclerview.R;
//import eg.gov.iti.recyclerview.pojo.MoviesModel;

public class MovieListingAdapter extends RecyclerView.Adapter<MovieListingAdapter.MovieListingViewHolder> {
    private ArrayList<MoviesModel> moviesList = new ArrayList<>();

    @NonNull
    @Override
    public MovieListingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MovieListingViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_listing_items, parent, false));
    }


    @Override
    public void onBindViewHolder(@NonNull MovieListingViewHolder holder, int position) {
        MoviesModel moviesModel = moviesList.get(position);
        holder.movie_name_txt.setText(moviesModel.getTitle());
        holder.movie_year_txt.setText(moviesModel.getReleaseDate());
        Glide.with(holder.itemView)
                .load(moviesModel.getImages()).placeholder(R.drawable.mob).fitCenter()
                .into(holder.movie_img);
        holder.movie_Cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DetailsFragment detailsFragment = new DetailsFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("movieId", moviesModel.getId());
                detailsFragment.setArguments(bundle);
                AppCompatActivity activity1 = (AppCompatActivity) view.getContext();
                activity1.getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, detailsFragment)
                        .addToBackStack("").commit();

            }
        });

    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public void setList(ArrayList<MoviesModel> moviesList) {
        this.moviesList = moviesList;
        notifyDataSetChanged();
    }

    public class MovieListingViewHolder extends RecyclerView.ViewHolder {
        ImageView movie_img;
        TextView movie_name_txt, movie_year_txt;
        CardView movie_Cv;

        public MovieListingViewHolder(@NonNull View itemView) {
            super(itemView);
            movie_img = itemView.findViewById(R.id.movie_img);
            movie_name_txt = itemView.findViewById(R.id.movie_name_txt);
            movie_year_txt = itemView.findViewById(R.id.movie_year_txt);
            movie_Cv = itemView.findViewById(R.id.movie_CV);
        }
    }
}