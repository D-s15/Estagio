package com.example.bejamonuments;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class MonumentViewModel extends ViewModel {

    Repository repository = new Repository();

    public LiveData<List<Monument>> getMonumentsList(){
        return this.repository.getMonumentsList();
    }

    public LiveData<Monument> getMonument(Context context, long id){
        return this.repository.getMonument(context, id);
    }

    public void updateMonuments(Context context){
        this.repository.updateMonuments(context);
    }
}
