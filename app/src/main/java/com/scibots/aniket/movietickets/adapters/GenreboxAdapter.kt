package com.scibots.aniket.movietickets.adapters

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.scibots.aniket.movietickets.R
import java.util.*

/**
 * Created by aniket on 27/5/17.
 */

class GenreboxAdapter(internal var context: Context, Moviesdataset: ArrayList<String>) : RecyclerView.Adapter<GenreboxAdapter.ViewHolder>() {
    internal var innerAdapter: card_layout_adapter

    init {
        innerAdapter = card_layout_adapter(Moviesdataset)
    }

    override fun onCreateViewHolder(parent: ViewGroup, i: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.genrebox, parent, false)
        val v = ViewHolder(view)
        return v
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {

    }

    override fun getItemCount(): Int {
        return 14
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var innerRecyclerView: RecyclerView
            internal set

        init {
            innerRecyclerView = itemView.findViewById(R.id.movieRecyler) as RecyclerView
            innerRecyclerView.layoutManager = LinearLayoutManager(context.applicationContext, LinearLayoutManager.HORIZONTAL, false)
            innerRecyclerView.adapter = innerAdapter
        }
    }
}
