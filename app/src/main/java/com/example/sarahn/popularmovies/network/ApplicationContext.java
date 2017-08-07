package com.example.sarahn.popularmovies.network;

import android.app.Application;
import android.content.Context;

/**
 * Created by SarahN on 8/7/2017.
 */
public class ApplicationContext extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }
   // private ApplicationContext(){}

    public static final Context getContextInstance(){
//        if(mContext.equals(null)){
//             mContext = getApplicationContext();
//        }
        return mContext;
    }
}
