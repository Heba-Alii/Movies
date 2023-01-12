package com.heba.movies.ui.listing;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.heba.movies.R;
import com.heba.movies.pojo.MoviesModel;

import java.util.ArrayList;

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

        public MovieListingViewHolder(@NonNull View itemView) {
            super(itemView);
            movie_img = itemView.findViewById(R.id.movie_img);
            movie_name_txt = itemView.findViewById(R.id.movie_name_txt);
            movie_year_txt = itemView.findViewById(R.id.movie_year_txt);


        }
    }
}