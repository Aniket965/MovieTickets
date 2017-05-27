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
    private ArrayList<HashMap<Integer, String>> dataset;


    public card_layout_adapter(Integer id, String name, Context context) {
        this.name = name;
        this.id = id;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
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
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        switch (viewHolder.getItemViewType()) {
            case 0:
                ViewHolder1 v1 = (ViewHolder1) viewHolder;
                //           v1.mGenre.setText(dataset.indexOf(i));


                Log.d("QW", name + "    " + id);


                break;
            default:
                ViewHolder v = (ViewHolder) viewHolder;
//                v.mTitle.setText(dataset.get(i));
                break;
        }
    }


    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTitle;
        public ImageView img;

        public ViewHolder(View itemView) {
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.title);
            img = (ImageView) itemView.findViewById(R.id.poster);

            Picasso.with(context).load("https://image.tmdb.org/t/p/w154//l76lnVXe34KumtSd28dSHqZ9Uw5.jpg").into(img);

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
