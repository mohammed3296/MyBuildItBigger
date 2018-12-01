package com.example.mohammedabdullah3296.myandroidlib;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokesDisplayAct extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes_display);
        Intent intent = getIntent();
        if (intent.hasExtra("JOKE_TEXT")) {
            textView = (TextView) findViewById(R.id.joke_text);
            textView.setText(intent.getStringExtra("JOKE_TEXT"));
        }

    }
}
