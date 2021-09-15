package com.example.bejamonuments;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class InterestPointViewModel extends ViewModel {

    Repository repository = new Repository();

    public LiveData<List<InterestPoint>> getInterestPointList(long monumentId, Context context) {
        return this.repository.getInterestPointsByMonumentId(monumentId, context);
    }

    public LiveData<InterestPoint> getInterestPoint(long id, Context context) {
        return this.repository.getIntetestPoint(id, context);
    }

    public void changeSeen(Context context, long id, boolean isSeen) {
        this.repository.changeSeen(context, id, isSeen);
    }

    public InterestPointVisited getVisitedState(Context context, long interestPointId) {
        return this.repository.getInterestPointVisitedState(context, interestPointId);
    }
}
