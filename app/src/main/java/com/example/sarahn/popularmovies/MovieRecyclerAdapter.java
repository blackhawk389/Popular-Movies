package com.example.sarahn.popularmovies;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sarahn.popularmovies.network.ApplicationContext;

/**
 * Created by SarahN on 8/6/2017.
 */

//which type of viewholder because in implementing methods we need viewholder so we should specify

public class MovieRecyclerAdapter extends RecyclerView.Adapter<MovieRecyclerAdapter.MovieViewHolder> {
    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ApplicationContext.getContextInstance()).inflate(R.layout.grid_view_item, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        holder.onBind();
    }
    @Override
    public int getItemCount() {
        return 50;
    }

    //for the caching and reusing also responsible for
    class MovieViewHolder extends RecyclerView.ViewHolder{

        ImageView mMovieImageView;

        public MovieViewHolder(View itemView) {
            super(itemView);  //initializing view in prent clas
            //since view re to be reused and recycler in viewholder of recycler view
            mMovieImageView = (ImageView) itemView.findViewById(R.id.iv);

        }

        public void onBind(){
            mMovieImageView.setImageResource(R.drawable.micky);
        }
    }
}
