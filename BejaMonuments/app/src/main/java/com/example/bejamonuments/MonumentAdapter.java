package com.example.bejamonuments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MonumentAdapter extends BaseAdapter {
    private List<Monument> monumentList = new ArrayList<>();
    private Context context;

    public MonumentAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return monumentList.size();
    }

    @Override
    public Monument getItem(int position) {
        return this.monumentList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null){
            convertView = LayoutInflater.from(this.context).inflate(R.layout.monument_row, parent, false);
        }

        Monument monument = this.getItem(position);

        TextView textViewMonumentName = convertView.findViewById(R.id.textViewMonumentName);
        ImageView imageViewMonumentImage = convertView.findViewById(R.id.imageViewMonumentImage);

        textViewMonumentName.setText(monument.getName());
        Glide.with(this.context).load(monument.getImage()).into(imageViewMonumentImage);

        return convertView;
    }

    public void updateUI(List<Monument> newMonumentsList){
        this.monumentList = newMonumentsList;
        notifyDataSetChanged();
    }
}
