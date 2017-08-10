package com.example.sarahn.popularmovies;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;


public class DetailActivity extends AppCompatActivity {

    ImageView iv;
    ImageView ivPoster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        iv = (ImageView)findViewById(R.id.backdrop);
        ivPoster = (ImageView)findViewById(R.id.iv_poster);
        iv.setImageResource(R.drawable.flower);

        ivPoster.setImageResource(R.drawable.micky);



    }
}
