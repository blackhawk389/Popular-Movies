package com.example.sarahn.popularmovies.network;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by SarahN on 8/6/2017.
 */
public class NetworkUntils {

    private static RequestQueue mRequestQueue = Volley.newRequestQueue(ApplicationContext.getContextInstance());

    private NetworkUntils(){
        Log.i("mainactivity", " constructor");
    }

    //making this function thread safe if any two threads see initialzing null then
    //both will make object and it will destroy rule
    synchronized public static RequestQueue getInstance(){
        //declared not initialized
//        if(mRequestQueue.equals(null)){
//              mRequestQueue = Volley.newRequestQueue(ApplicationContext.getContextInstance());
//        }
        return mRequestQueue;
    }

    public static void addToRequestQueue(Request request){
        mRequestQueue.add(request);
    }
}
