package com.scibots.aniket.movietickets.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.scibots.aniket.movietickets.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by aniket on 26/5/17.
 */

public class card_layout_adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    String name;
    int id;
    private ArrayList<HashMap<Integer, String>> dataset = null;


    public card_layout_adapter(Integer id, String name, Context context, ArrayList<HashMap<Integer, String>> dataset) {
        this.name = name;
        this.id = id;
        this.context = context;
        this.dataset = dataset;
        Log.d(" fgdf", "" + dataset.size());


    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Log.d(" fgdf", "" + dataset.size());

        if (i == 0) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.genretitle, parent, false);
            ViewHolder1 vh = new ViewHolder1(v);

            return vh;

        } else {


            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.customcardview, parent, false);
            ViewHolder vh = new ViewHolder(v);

            return vh;
        }
    }


    @Override
    public void onViewRecycled(RecyclerView.ViewHolder holder) {
        super.onViewRecycled(holder);


    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {


        switch (viewHolder.getItemViewType()) {
            case 0:
                ViewHolder1 v1 = (ViewHolder1) viewHolder;





                break;
            default:

                ViewHolder v = (ViewHolder) viewHolder;
                String url;

                if (dataset.size() > 0) {
                    for (Integer key : dataset.get(i - 1).keySet()) {
                        url = dataset.get(i - 1).get(key);
                        Picasso.with(context).load("https://image.tmdb.org/t/p/w154/" + url).into(v.img);

                    }


                }
                break;
        }
    }


    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTitle;
        public ImageView img;


        public ViewHolder(View itemView) {
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.title);
            img = (ImageView) itemView.findViewById(R.id.poster);


        }


    }

    public class ViewHolder1 extends RecyclerView.ViewHolder {
        public TextView mGenre;

        public ViewHolder1(View itemView) {
            super(itemView);
            mGenre = (TextView) itemView.findViewById(R.id.genre);
            mGenre.setText(name);

        }

    }
}
