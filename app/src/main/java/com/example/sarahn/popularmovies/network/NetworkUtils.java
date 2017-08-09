package com.example.sarahn.popularmovies.network;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.sarahn.popularmovies.MainActivity;
import com.example.sarahn.popularmovies.model.ModelDataClass;
import com.squareup.picasso.Downloader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SarahN on 8/8/2017.
 */
public class NetworkUtils{

    RequestQueue mRequestQueue;
    JSONObject response;
    ModelDataClass data;
    JSONArray arrayData;
    MainActivity mMainActivity;

    public NetworkUtils(MainActivity m) {
        this.mRequestQueue = VolleyInitializeSingleton.getInstance();
        mMainActivity = m;
    }

    public void makeRequest(String url){
        JsonObjectRequest jsonrequest = new JsonObjectRequest(Request.Method.GET, url, null, mMainActivity, mMainActivity);
        addToRequestQueue(jsonrequest);
    }

    public void addToRequestQueue(Request request){
        mRequestQueue.add(request);
    }
}
