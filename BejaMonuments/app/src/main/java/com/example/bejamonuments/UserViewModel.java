package com.example.bejamonuments;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class UserViewModel extends ViewModel {

    private Repository repository = new Repository();

    public LiveData<List<User>> getUsers(Context context) {
        return this.repository.getUsers(context);
    }

    public LiveData<User> getUser(String email, String password, Context context) {
        return this.repository.getUser(email, password, context);
    }

    public void newUser(String username, String email, String phone, String password, Context context) {
        this.repository.newUser(username, email, phone, password, context);
    }

    public void updateUsers(Context context) {
        this.repository.updateUsers(context);
    }

    public User getUserByEmail(Context context, String email) {
        return this.repository.getUserByEmail(email, context);
    }

    public boolean loginUser(Context context, String email, String password) {
        User user = this.getUserByEmail(context, email);
        if (user != null) {
            return user.getPassword().equals(password);
        }
        return false;
    }
}
