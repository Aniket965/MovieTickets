package com.scibots.aniket.movietickets

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

class HomeScreen : AppCompatActivity() {
    private var mRecylerview: RecyclerView? = null
    private var mLayoutManager: RecyclerView.LayoutManager? = null
    private var mAdapter: RecyclerView.Adapter<*>? = null
    private var dataset: ArrayList<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)
        // filing data set with titles
        dataset = ArrayList<String>();
        var x: Int = 0
        while (x < 10) {
            dataset?.add("Movie # $x");
            x++;
        }
        // setting Recycler View
        mRecylerview = findViewById(R.id.scrollcardView) as RecyclerView?;
        mRecylerview?.setHasFixedSize(true);


        //setting Layout Manager
        mLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecylerview?.layoutManager = mLayoutManager;

        //setting adapter

        mAdapter = card_layout_adapter(dataset);
        mRecylerview?.adapter = mAdapter;


    }
}
