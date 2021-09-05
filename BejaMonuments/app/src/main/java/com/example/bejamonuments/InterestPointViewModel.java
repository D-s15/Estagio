package com.example.bejamonuments;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class InterestPointViewModel extends ViewModel {

    Repository repository = new Repository();

    public LiveData<List<InterestPoint>> getInterestPointList(long monumentId, Context context){
        return this.repository.getInterestPointsByMonumentId(monumentId, context);
    }

    public LiveData<InterestPoint> getInterestPoint(long id, Context context) {
        return this.repository.getIntetestPoint(id, context);
    }
}
