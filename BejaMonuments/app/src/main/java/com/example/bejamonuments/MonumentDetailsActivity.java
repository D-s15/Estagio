package com.example.bejamonuments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.List;

public class MonumentDetailsActivity extends AppCompatActivity {

    private static final String KEY_ID = "id";
    private MonumentViewModel viewModel;
    private InterestPointViewModel interestPointViewModel;
    private InterestPointAdapter adapter;
    private List<InterestPoint> interestPointsList;
    private long id;
    private Monument monument;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monument_details);

        TextView monumentName = findViewById(R.id.MonumentName);
        ImageView monumentImage = findViewById(R.id.MonumentImage);
        TextView monumentDayOff = findViewById(R.id.monumentDayOff);
        TextView monumentSchedule = findViewById(R.id.monumentSchedule);
        TextView monumentLocation = findViewById(R.id.monumentLocation);
        TextView monumentDescription = findViewById(R.id.monumentDescription);
        RatingBar ratingBar = findViewById(R.id.ratingBar);
        ImageButton imageButton = findViewById(R.id.imageButton);

        this.viewModel = new ViewModelProvider(this).get(MonumentViewModel.class);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            this.id = bundle.getLong(KEY_ID, -1);
            if (this.id > 0) {
                this.viewModel.getMonument(this, id).observe(MonumentDetailsActivity.this, new Observer<Monument>() {
                    @Override
                    public void onChanged(Monument monument) {
                        Glide.with(MonumentDetailsActivity.this).load(monument.getImage()).into(monumentImage);
                        monumentName.setText(monument.getName());
                        monumentDayOff.setText(monument.getDayOff());
                        monumentSchedule.setText("Abre das " + monument.getSchedule_AM() + " e das " + monument.getSchedule_PM());
                        monumentDescription.setText(monument.getDescription());
                        int numOfStars = ratingBar.getNumStars();
                        }
                });
            }
            if (this.id == -1) {
                finish();
            }
        }

        this.interestPointViewModel = new ViewModelProvider(this).get(InterestPointViewModel.class);
        this.viewModel.updateMonuments(this);

        ListView listView = (ListView) findViewById(R.id.interestPointList);
        this.adapter = new InterestPointAdapter(this);
        listView.setAdapter(this.adapter);
        this.interestPointViewModel.getInterestPointList(id,this).observe(this, new Observer<List<InterestPoint>>() {
            @Override
            public void onChanged(List<InterestPoint> interestPoints) {
                MonumentDetailsActivity.this.interestPointsList = interestPoints;
                MonumentDetailsActivity.this.adapter.updateUI(interestPoints);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MonumentDetailsActivity.this, InterestPointDetailsActivity.class);
                intent.putExtra(InterestPointDetailsActivity.POINT_ID, id);
                startActivity(intent);
            }
        });

    }

    public void onClickMap(View view){
    this.viewModel.getMonument(this, id).observe(this, new Observer<Monument>() {
        @Override
        public void onChanged(Monument monument) {
            String url = monument.getLocation();

            Intent intent = new Intent();
            intent.setAction(intent.ACTION_VIEW);
            intent.addCategory(intent.CATEGORY_BROWSABLE);

            intent.setData(Uri.parse(url));

            startActivity(intent);}
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.interestPointViewModel.getInterestPointList(id, this).observe(this, new Observer<List<InterestPoint>>() {
            @Override
            public void onChanged(List<InterestPoint> interestPoints) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (InterestPoint interestPoint : interestPoints) {
                            InterestPointVisited interestPointVisited = interestPointViewModel.getVisitedState(MonumentDetailsActivity.this, interestPoint.getId());
                            if (interestPointVisited != null) interestPoint.setVisited(interestPointVisited.isVisited());
                        }
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                MonumentDetailsActivity.this.adapter.updateUI(interestPoints);
                            }
                        });
                    }
                }).start();
            }
        });
    }
}