package com.example.bejamonuments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment {

    private MonumentViewModel viewModel;
    private List<Monument> monumentList;
    private MonumentAdapter adapter;

    public MainFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        ListView listView = (ListView) view.findViewById(R.id.listViewMonuments);

        this.adapter = new MonumentAdapter(getActivity());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MonumentFragment monumentFragment = new MonumentFragment();
                Bundle args = new Bundle();
                args.putString("KEY_ID", String.valueOf(id));

                monumentFragment.setArguments(args);
                FragmentManager manager = getChildFragmentManager();
                manager.beginTransaction()
                        .replace(R.id.fragment_container, new MonumentFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(MonumentViewModel.class);
        viewModel.getMonumentsList().observe(getActivity(), new Observer<List<Monument>>() {
            @Override
            public void onChanged(List<Monument> monuments) {
                MainFragment.this.monumentList = monuments;
                MainFragment.this.adapter.updateUI(monuments);
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        this.viewModel.updateMonuments(getActivity());
    }
}