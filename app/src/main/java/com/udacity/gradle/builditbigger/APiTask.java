package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Pair;

import com.example.mohammedabdullah3296.myandroidlib.JokesDisplayAct;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

/**
 * Created by Mohammed El_amary on 2/14/2018.
 */

public  class APiTask extends AsyncTask<Pair<Context, String>, Void, String> {
    private  Context mContext;
    private MyApi mMyApi = null;
    public APiTask(Context context) {
        this.mContext = context;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(Pair<Context, String>... params) {
        if (mMyApi == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/");//https://folkloric-alpha-183801.appspot.com/_ah/api/
            mMyApi = builder.build();
        }
        try {
            return mMyApi.sayHi("Mohammed_Abdullah").execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        Intent intent = new Intent(mContext, JokesDisplayAct.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("JOKE_TEXT", result);
        mContext.startActivity(intent);
    }
}