package com.example.bejamonuments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class InterestPointDetailsActivity extends AppCompatActivity {

    public static final String POINT_ID = "id";
    private long id;
    private InterestPointViewModel viewModel;
    private InterestPoint interestPoint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interest_point_details);

        TextView textViewPointName = findViewById(R.id.textViewPointName);
        TextView textViewPointDescription = findViewById(R.id.textViewPointdescription);
        ImageView imageViewPointImage = findViewById(R.id.imageViewPointImage);
        RatingBar ratingBar = findViewById(R.id.ratingBar);

        this.viewModel = new ViewModelProvider(this).get(InterestPointViewModel.class);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            this.id = bundle.getLong(POINT_ID);
            if (id > 0){
                this.viewModel.getInterestPoint(id, this).observe(this, new Observer<InterestPoint>() {
                    @Override
                    public void onChanged(InterestPoint interestPoint) {

                        textViewPointName.setText(interestPoint.getName());
                        textViewPointDescription.setText(interestPoint.getDescription());
                        Glide.with(InterestPointDetailsActivity.this).load(interestPoint.getImage()).into(imageViewPointImage);
                        int numStars = interestPoint.getRating();
                        ratingBar.setRating(numStars);
                    }
                });
            }
            if (id == -1){
                finish();
            }
        }
    }
}