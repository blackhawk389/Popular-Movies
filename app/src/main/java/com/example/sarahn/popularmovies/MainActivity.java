package com.example.sarahn.popularmovies;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.GridLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.sarahn.popularmovies.network.NetworkUntils;


public class MainActivity extends AppCompatActivity implements Response.Listener,
        Response.ErrorListener{

    Toolbar toolbar;
    RecyclerView recyclerView;
    final String API_KEY = "d08fbb5825137a70b2198e709c7a8c58";
    String url = "https://api.themoviedb.org/3/discover/" +
            "movie?api_key="+API_KEY+"&primary_release_date.gte=2017-07" +
            "-01&primary_release_date.lte=2017-08-07";

    RecyclerView.OnItemTouchListener mListner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initToolbar();
        makeRequest();
        initRecyclerView();
    }

    private void initViews(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.rv);
    }

    private void initToolbar(){

        toolbar.inflateMenu(R.menu.menu_main);
        toolbar.setTitle("Popular Movies");

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                int id = menuItem.getItemId();

                //noinspection SimplifiableIfStatement
                if (id == R.id.action_popular) {

                }else if(id == R.id.action_most_rated){

                }
                return false;

            }
        });
    }

    private void initRecyclerView(){
        GridLayoutManager grid = new GridLayoutManager(this,2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new MovieRecyclerAdapter());
        recyclerView.setLayoutManager(grid);

    }

   private void makeRequest(){
       NetworkUntils.getInstance();
       JsonObjectRequest jsonrequest = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
       NetworkUntils.addToRequestQueue(jsonrequest);
   }

    @Override
    public void onResponse(Object o) {
        Log.i("mainactivity", o.toString());
    }

    @Override
    public void onErrorResponse(VolleyError volleyError) {

        Log.i("mainactivity", "Error");
    }

}