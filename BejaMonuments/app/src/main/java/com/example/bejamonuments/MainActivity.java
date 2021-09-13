package com.example.bejamonuments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private UserAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void createAccount(View view){
        Intent intent = new Intent(this, RegisterAccountActivity.class);
        startActivity(intent);
    }

    public void onClickLogin(View view){
        Intent intent = new Intent(this, MonumentListActivity.class);
        startActivity(intent);
    }
}