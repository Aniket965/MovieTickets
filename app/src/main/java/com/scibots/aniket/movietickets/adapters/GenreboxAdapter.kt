package com.scibots.aniket.movietickets.adapters

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.scibots.aniket.movietickets.R

/**
 * Created by aniket on 27/5/17.
 */

class GenreboxAdapter(internal var context: Context, Moviesdataset: ArrayList<HashMap<Int, String>>) : RecyclerView.Adapter<GenreboxAdapter.ViewHolder>() {

    internal var genredataset: ArrayList<HashMap<Int, String>>
    var genrename: String? = null
    var genreid: Int? = null


    init {
        genredataset = Moviesdataset


    }

    override fun onCreateViewHolder(parent: ViewGroup, i: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.genrebox, parent, false)
        val v = ViewHolder(view)
        return v
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        for (key in genredataset.get(i).keys) {
            genreid = key
            genrename = genredataset.get(i).get(key)
            Log.d("QW", genredataset.get(i).get(key) + "");
            viewHolder.setAdapter(genrename!!, genreid!!)

        }

    }

    override fun getItemCount(): Int {
        return genredataset.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var innerRecyclerView: RecyclerView
            internal set
        internal var innerAdapter: card_layout_adapter? = null

        init {

            innerRecyclerView = itemView.findViewById(R.id.movieRecyler) as RecyclerView


        }

        public fun setAdapter(name: String, id: Int) {
            innerAdapter = card_layout_adapter(id, name, context)
            innerRecyclerView.adapter = innerAdapter
            innerRecyclerView.layoutManager = LinearLayoutManager(context.applicationContext, LinearLayoutManager.HORIZONTAL, false)

        }
    }
}
