package com.example.bejamonuments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

public class MonumentListActivity extends AppCompatActivity {

    private static final String KEY_ID = "id";
    private MonumentViewModel viewModel;
    private MonumentAdapter adapter;
    private List<Monument> monumentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monument_list);

        this.viewModel = new ViewModelProvider(this).get(MonumentViewModel.class);

        ListView listView = (ListView) findViewById(R.id.MonumentsList);
        this.adapter = new MonumentAdapter(this);
        listView.setAdapter(this.adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MonumentListActivity.this, MonumentDetailsActivity.class);
                intent.putExtra(KEY_ID, id);
                startActivity(intent);
            }
        });

        this.viewModel.getMonumentsList().observe(this, new Observer<List<Monument>>() {
            @Override
            public void onChanged(List<Monument> monuments) {
                MonumentListActivity.this.monumentList = monuments;
                MonumentListActivity.this.adapter.updateUI(monuments);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        this.viewModel.updateMonuments(this);
    }
}