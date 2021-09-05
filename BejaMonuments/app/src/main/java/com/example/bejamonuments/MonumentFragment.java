package com.example.bejamonuments;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MonumentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MonumentFragment extends Fragment {

    private static final String KEY_ID = "id";
    private MonumentViewModel monumentViewModel;
    private InterestPointViewModel interestPointViewModel;
    private InterestPointAdapter adapter;
    private List<InterestPoint> interestPointList;
    private long id;
    private TextView monumentName;
    private ImageView monumentImage;
    private TextView morningSchedule;
    private TextView afternoonSchedule;
    private TextView description;
    private TextView location;
    private TextView dayOff;

    // TODO: Rename and change types of parameters

    public MonumentFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment SecondFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MonumentFragment newInstance() {
        MonumentFragment fragment = new MonumentFragment();
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_monument, container, false);

        this.monumentName = view.findViewById(R.id.textViewMonumentName);
        this.morningSchedule = view.findViewById(R.id.monumentMorningSchedule);
        this.afternoonSchedule = view.findViewById(R.id.monumentAfternoonSchedule);
        this.description = view.findViewById(R.id.monumentDescription);
        this.dayOff = view.findViewById(R.id.monumentDayOff);
        this.location = view.findViewById(R.id.monumentLocation);
        this.monumentImage = view.findViewById(R.id.imageViewMonumentImage);

        ListView listView = view.findViewById(R.id.listViewInterestPoints);
        String key = getArguments().getString("KEY_ID");
        Bundle bundle = getArguments();
        if (bundle != null){
            this.id = bundle.getLong(KEY_ID, -1);
        }
        if (this.id > 0){
            this.monumentViewModel.getMonument(getActivity(), id).observe(getActivity(), new Observer<Monument>() {
                @Override
                public void onChanged(Monument monument) {
                    monumentName.setText(monument.getName());
                    morningSchedule.setText(monument.getSchedule_AM());
                    afternoonSchedule.setText(monument.getSchedule_PM());
                    dayOff.setText(monument.getDayOff());
                    location.setText(monument.getLocation());
                    description.setText(monument.getDescription());
                    Glide.with(getActivity()).load(monument.getImage());
                }
            });
        }
        if (this.id == -1){ getActivity().finish();}

        this.adapter = new InterestPointAdapter();
        listView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.interestPointViewModel = new ViewModelProvider(getActivity()).get(InterestPointViewModel.class);
        interestPointViewModel.getInterestPointList(id, getActivity()).observe(getActivity(), new Observer<List<InterestPoint>>() {
            @Override
            public void onChanged(List<InterestPoint> interestPoints) {
                MonumentFragment.this.interestPointList = interestPoints;
                MonumentFragment.this.adapter.updateUI(interestPoints);
            }
        });
    }
}