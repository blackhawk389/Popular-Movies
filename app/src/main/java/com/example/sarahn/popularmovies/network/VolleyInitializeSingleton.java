package com.example.sarahn.popularmovies.network;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.sarahn.popularmovies.ApplicationContext;

/**
 * Created by SarahN on 8/6/2017.
 */
public class VolleyInitializeSingleton {

    String url;
    private static RequestQueue mRequestQueue = Volley.newRequestQueue(ApplicationContext.getContextInstance());

    private VolleyInitializeSingleton(){
        Log.i("mainactivity", " constructor");
    }

    //making this function thread safe if any two threads see initialzing null then
    //both will make object and it will destroy rule
    synchronized public static RequestQueue getInstance(){
        //declared not initialized
        if(mRequestQueue.equals(null)){
              mRequestQueue = Volley.newRequestQueue(ApplicationContext.getContextInstance());
        }
        return mRequestQueue;
    }
}
