package com.scibots.aniket.movietickets

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.TextView
import com.scibots.aniket.movietickets.adapters.GenreboxAdapter

class HomeScreen : AppCompatActivity() {
    private var mRecylerview: RecyclerView? = null
    private var mLayoutManager: RecyclerView.LayoutManager? = null
    private var mAdapter: RecyclerView.Adapter<*>? = null
    private var dataset: ArrayList<String>? = null
    private var textview: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)
//        // test request
//        textview = findViewById(R.id.response) as TextView?
//        var RequesQue:RequestQueue = Volley.newRequestQueue(this)
//        var url = "https://api.themoviedb.org/3/movie/550?api_key=f42a418b0aba174156496701672bebf7"
//        var stringRequest = StringRequest(Request.Method.GET, url,
//                object:Response.Listener<String> {
//                  override  fun onResponse(response:String) {
//                        // Display the first 500 characters of the response string.
//                      Log.d("Hello",response);
//                        textview?.setText("Response is: " + response.substring(0, 500))
//                    }
//                }, object:Response.ErrorListener {
//                   override  fun onErrorResponse(error: VolleyError) {
//                       textview?.setText("That didn't work!")
//            }
//        })
//
//        RequesQue.add(stringRequest)



        // filing data set with titles
        dataset = ArrayList<String>();
        var x: Int = 0
        while (x < 10) {
            dataset?.add("Animated ");
            x++;
        }
        // setting Recycler View
        mRecylerview = findViewById(R.id.genrebox) as RecyclerView?;
        mRecylerview?.setHasFixedSize(true);


        //setting Layout Manager
        mLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecylerview?.layoutManager = mLayoutManager;

        //setting adapter

        mAdapter = GenreboxAdapter(this, dataset!!);
        mRecylerview?.adapter = mAdapter;


    }
}
