package com.example.bejamonuments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class InterestPointDetailsActivity extends AppCompatActivity {

    public static final String POINT_ID = "id";
    private long id;
    private InterestPointViewModel viewModel;
    private InterestPoint interestPoint;
    private TextView textViewPointName;
    private ImageView imageViewPointImage;
    private TextView textViewPointDescription;
    private Button toggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interest_point_details);

        this.textViewPointName = findViewById(R.id.textViewPointName);
        this.imageViewPointImage = findViewById(R.id.imageViewPointImage);
        this.textViewPointDescription = findViewById(R.id.textViewPointDescription);
        RatingBar ratingBar = findViewById(R.id.ratingBar);
        Button changeSeenButton = findViewById(R.id.buttonToggleVisited);
        Button submitButton = findViewById(R.id.buttonSubmit);

        this.viewModel = new ViewModelProvider(this).get(InterestPointViewModel.class);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            this.id = bundle.getLong(POINT_ID);
            if (id > 0){
                this.viewModel.getInterestPoint(this.id, this).observe(this, new Observer<InterestPoint>() {
                    @Override
                    public void onChanged(final InterestPoint interestPoint) {
                        textViewPointName.setText(interestPoint.getName());
                        textViewPointDescription.setText(interestPoint.getDescription());
                        Glide.with(InterestPointDetailsActivity.this).load(interestPoint.getImage()).into(imageViewPointImage);

                  //      new Thread(new Runnable() {
                  //          @Override
                  //          public void run() {
                  //              InterestPointVisited interestPointVisited = viewModel.getVisitedState(InterestPointDetailsActivity.this, interestPoint.getId());
                  //              if (interestPointVisited != null) interestPoint.setVisited(interestPointVisited.isVisited());
                  //              InterestPointDetailsActivity.this.interestPoint = interestPoint;
                  //              runOnUiThread(new Runnable() {
                  //                  @Override
                  //                  public void run() {
                  //                      updateUI();
                  //                  }
                  //              });
                  //          }
                  //      }).start();
                    }
                });
            }
        }
            if (id == -1){
                finish();
            }
            submitButton.setText("Submeter Classificação");
        }

    public void onClickToggleSeen(View view){
        this.interestPoint.setVisited(!this.interestPoint.isVisited());

        this.viewModel.changeSeen(this, this.interestPoint.getId(), this.interestPoint.isVisited());
        this.toggleSeenButtonText(this.interestPoint.isVisited());
    }

    private void updateUI() {
        if (this.interestPoint != null) this.toggleSeenButtonText(this.interestPoint.isVisited());
        textViewPointName.setText(interestPoint.getName());
        Glide.with(InterestPointDetailsActivity.this).load(interestPoint.getImage()).apply(new RequestOptions().override(600, 600)).into(imageViewPointImage);
        textViewPointDescription.setText("Descrição: " + interestPoint.getDescription());
    }

    private void toggleSeenButtonText(boolean isSeen) {
        this.toggleButton.setText(isSeen ? "marcar ponto de interesse como não visto" : "marcar ponto de interesse como visto");
    }
}