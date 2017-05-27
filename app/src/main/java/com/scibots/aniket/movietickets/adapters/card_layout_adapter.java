package com.scibots.aniket.movietickets.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.scibots.aniket.movietickets.R;

import java.util.ArrayList;

/**
 * Created by aniket on 26/5/17.
 */

public class card_layout_adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<String> dataset;

    public card_layout_adapter(ArrayList<String> dataset) {
        this.dataset = dataset;
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
                v1.mGenre.setText(dataset.get(i));
                break;
            default:
                ViewHolder v = (ViewHolder) viewHolder;
                v.mTitle.setText(dataset.get(i));
                break;
        }
    }


    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.title);

        }
    }

    public class ViewHolder1 extends RecyclerView.ViewHolder {
        public TextView mGenre;

        public ViewHolder1(View itemView) {
            super(itemView);
            mGenre = (TextView) itemView.findViewById(R.id.genre);
        }
    }
}
