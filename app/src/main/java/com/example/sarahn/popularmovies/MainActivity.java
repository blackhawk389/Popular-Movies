package com.example.sarahn.popularmovies;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.sarahn.popularmovies.interfaces.OnItemIndexClickListener;
import com.example.sarahn.popularmovies.model.ModelDataClass;
import com.example.sarahn.popularmovies.network.NetworkUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements OnItemIndexClickListener.ClickListener
, Response.Listener, Response.ErrorListener{

    Toolbar toolbar;
    RecyclerView recyclerView;
    final String API_KEY = "d08fbb5825137a70b2198e709c7a8c58";
    String url = "https://api.themoviedb.org/3/discover/" +
            "movie?api_key="+API_KEY+"&primary_release_date.gte=2017-07" +
            "-01&primary_release_date.lte=2017-08-07";
    NetworkUtils networkUtils;
    JSONArray arrayData;

    ProgressBar pb;
    static List<ModelDataClass> list = new ArrayList<ModelDataClass>();
    ModelDataClass data;
    JSONObject response;

    public static List<ModelDataClass> getList() {
        return list;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        networkUtils = new NetworkUtils(this);
        networkUtils.makeRequest(url);

        initViews();
        initToolbar();
       // initRecyclerView();
    }

    private void initViews(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.rv);
        pb = (ProgressBar) findViewById(R.id.pb);
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

                    String url = "https://api.themoviedb.org/3/discover/" +
                    "movie?sort_by=popularity.desc?api_key="+API_KEY+"&primary_release_date.gte=2017-07" +
                            "-01&primary_release_date.lte=2017-08-07";
                    networkUtils.makeRequest(url);



                } else if (id == R.id.action_most_rated) {

                }
                return false;

            }
        });
    }

    private void initRecyclerView(){
        GridLayoutManager grid = new GridLayoutManager(this,2);
        recyclerView.setHasFixedSize(true);
        //needs any class that implemented method class

        recyclerView.setAdapter(new MovieRecyclerAdapter(this, MainActivity.this));
        recyclerView.setLayoutManager(grid);

    }


    @Override
    public void displayIndex(int position) {
        Toast.makeText(MainActivity.this, "Item clicked position "+position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onErrorResponse(VolleyError volleyError) {
        Log.i("mainactivity ", volleyError.toString());

    }

    @Override
    public void onResponse(Object o) {

        initRecyclerView();
        pb.setVisibility(View.GONE);

        Log.i("mainactivity ", o.toString());


        try {
            JSONObject jsonObject = new JSONObject(o.toString());
            arrayData = jsonObject.getJSONArray("results");
            data.setTotalResult(jsonObject.getInt("total_result"));
            Log.i("mainactivityki ", arrayData.toString());

        } catch (JSONException e) {
            e.printStackTrace();
        }

        for(int i =0; i < 50; i++) {

            data = new ModelDataClass();

            try {
                if (arrayData.equals("")) {
                    Log.i("mainactivity " , "null array data");
                }
                else{
                    response = arrayData.getJSONObject(i);
                    data.setTitle(response.getString("original_title"));
                    data.setRating(response.getDouble("vote_average"));
                    data.setDescription(response.getString("overview"));
                    data.setImage(response.getString("poster_path"));}


            }catch(JSONException e){
                e.printStackTrace();
            }
            list.add(data);
        }

    }
}