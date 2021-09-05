package com.example.bejamonuments;

import android.content.Context;
import android.service.controls.templates.ControlTemplate;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class InterestPointAdapter extends BaseAdapter {
    private List<InterestPoint> interestPointList = new ArrayList<>();
    private Context context;

    @Override
    public int getCount() {
        return interestPointList.size();
    }

    @Override
    public InterestPoint getItem(int position) {
        return interestPointList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(this.context).inflate(R.layout.interest_point_row, parent, false);
        }

        InterestPoint interestPoint = this.getItem(position);

        TextView textViewInterestPointName = convertView.findViewById(R.id.interestPointName);
        ImageView ImageViewInterestPointImage = convertView.findViewById(R.id.interestPointImage);

        textViewInterestPointName.setText(interestPoint.getName());
        Glide.with(this.context).load(interestPoint.getImage()).into(ImageViewInterestPointImage);

        return convertView;
    }

    public void updateUI(List<InterestPoint> newInterestPointList){
        this.interestPointList = newInterestPointList;
        notifyDataSetChanged();
    }
}
