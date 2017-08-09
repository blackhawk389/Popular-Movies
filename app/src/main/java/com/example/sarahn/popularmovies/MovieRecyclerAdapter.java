package com.example.sarahn.popularmovies;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.sarahn.popularmovies.interfaces.OnItemIndexClickListener;
import com.example.sarahn.popularmovies.model.ModelDataClass;
import com.example.sarahn.popularmovies.network.NetworkUtils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SarahN on 8/6/2017.
 */

//which type of viewholder because in implementing methods we need viewholder so we should specify

public class MovieRecyclerAdapter extends RecyclerView.Adapter<MovieRecyclerAdapter.MovieViewHolder> {

    OnItemIndexClickListener.ClickListener mListener;
    Context mContext;

    public MovieRecyclerAdapter(OnItemIndexClickListener.ClickListener listener, Context context) {
        mListener = listener;
        this.mContext = context;
    }

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
        return 20;
    }

    //for the caching and reusing also responsible for
    class MovieViewHolder extends RecyclerView.ViewHolder implements
            View.OnClickListener{

        ImageView mMovieImageView;

        public MovieViewHolder(View itemView) {
            super(itemView);  //initializing view in prent clas
            //since view re to be reused and recycler in viewholder of recycler view
            mMovieImageView = (ImageView) itemView.findViewById(R.id.iv);
            itemView.setOnClickListener(this);

        }

        public void onBind(){

                Picasso.with(mContext)
                        .load(MainActivity.getList().get(getAdapterPosition()).getImage()).placeholder(R.drawable.flower)
                        .into(mMovieImageView);
            //mMovieImageView.setImageResource();
        }

        @Override
        public void onClick(View v) {

            mListener.displayIndex(getAdapterPosition());
        }
    }
}
