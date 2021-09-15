package com.example.bejamonuments;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends BaseAdapter {
    private List<User> userList = new ArrayList<>();
    private Context context;

    public UserAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return userList.size();
    }

    @Override
    public User getItem(int position) {
        return userList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return userList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        return convertView;
    }

    public void updateUI(List<User> newUserList){
        this.userList = newUserList;
        notifyDataSetChanged();
    }
}
