package com.example.bejamonuments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class InterestPointDetailsActivity extends AppCompatActivity {

    public static final String POINT_ID = "id";
    private long id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interest_point_details);
    }
}