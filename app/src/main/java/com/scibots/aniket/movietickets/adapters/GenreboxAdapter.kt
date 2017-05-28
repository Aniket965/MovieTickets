package com.scibots.aniket.movietickets.adapters

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.scibots.aniket.movietickets.Que.MySingleton
import com.scibots.aniket.movietickets.R
import com.squareup.picasso.Picasso
import org.json.JSONException
import org.json.JSONObject


/**
 * Created by aniket on 27/5/17.
 */

class GenreboxAdapter(internal var context: Context, Moviesdataset: ArrayList<HashMap<Int, String>>) : RecyclerView.Adapter<GenreboxAdapter.ViewHolder>() {

    internal var genredataset: ArrayList<HashMap<Int, String>>
    var genrename: String? = null
    var genreid: Int? = null
    var moviesset: ArrayList<HashMap<Int, String>>? = null
    var isdataAdded: Boolean = false



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
            Log.d("adapter", "set")

            moviesset = getmoviesfromgenre(key, viewHolder, i)

            viewHolder.setAdapter(genrename!!, genreid!!, moviesset)

        }


    }

    private fun getmoviesfromgenre(id: Int?, viewHolder: ViewHolder, i: Int): java.util.ArrayList<java.util.HashMap<Int, String>> {
        var dataset = java.util.ArrayList<java.util.HashMap<Int, String>>()


        val url = "https://api.themoviedb.org/3/genre/$id/movies?api_key=f42a418b0aba174156496701672bebf7&language=en-US&include_adult=false&sort_by=created_at.asc"
        val jsObjRequest = JsonObjectRequest(Request.Method.GET, url, null, Response.Listener<JSONObject> { response -> dataset = parsemovies(response, dataset, viewHolder, id, i) }, Response.ErrorListener {
            // TODO Auto-generated method stub
        })
        MySingleton.getInstance(context).addToRequestQueue(jsObjRequest)
        return dataset as java.util.ArrayList<java.util.HashMap<Int, String>>
    }

    private fun parsemovies(response: JSONObject, data: ArrayList<HashMap<Int, String>>?, viewHolder: ViewHolder, id: Int?, j: Int): java.util.ArrayList<java.util.HashMap<Int, String>> {
        try {

            // Getting JSON Array node
            val movies = response.getJSONArray("results")

            // looping through All Contacts
            for (i in 0..movies.length() - 1) {

                val movie = movies.getJSONObject(i)
                if (i == j) {
                    var uri = movie.getString("backdrop_path")
                    viewHolder.setback(uri)

                }
                val m = java.util.HashMap<Int, String>()
                m.put(movie.getInt("id"), movie.getString("poster_path"))
//                Log.d("HOME", m.toString())
                data?.add(m)

            }
            viewHolder.innerAdapter?.notifyDataSetChanged()
        } catch (e: JSONException) {

        }

        return data!!
    }


    override fun getItemCount(): Int {
        return genredataset.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var innerRecyclerView: RecyclerView
        var img: ImageView
            internal set
        public var innerAdapter: card_layout_adapter? = null

        init {
            img = itemView.findViewById(R.id.back) as ImageView;
            innerRecyclerView = itemView.findViewById(R.id.movieRecyler) as RecyclerView


        }

        fun setAdapter(name: String, id: Int, data: ArrayList<HashMap<Int, String>>?) {


            innerAdapter = card_layout_adapter(id, name, context, data)
            innerRecyclerView.adapter = innerAdapter

            innerRecyclerView.layoutManager = LinearLayoutManager(context.applicationContext, LinearLayoutManager.HORIZONTAL, false)

        }

        fun setback(uri: String) {
            Picasso.with(context).load("https://image.tmdb.org/t/p/w500/" + uri).into(img)
        }


    }
}
