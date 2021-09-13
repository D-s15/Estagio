package com.example.bejamonuments;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {
    private UserDao userDao;
    private InterestPointDao interestPointDao;
    private MutableLiveData<List<Monument>> getMonumentsListLiveData = new MutableLiveData<>();
    private MutableLiveData<List<InterestPoint>> getInterestPointsListLiveData = new MutableLiveData<>();
    private MutableLiveData<Monument> getMonumentLiveData = new MutableLiveData<>();
    private MutableLiveData<InterestPoint> getInterestPointLiveData = new MutableLiveData<>();
    private AppService appService = Datasource.getAppService();

    private UserDao getUserDao(Context context){
        if (this.userDao == null){
            userDao = AppDatabase.getInstance(context).getUserDao();
        }
        return userDao;
    }

    private InterestPointDao getInterestPointDao(Context context) {
        if (this.interestPointDao == null){
            interestPointDao = AppDatabase.getInstance(context).getInterestPointDao();
    }
    return interestPointDao;
    }

    public LiveData<List<Monument>> getMonumentsList(){
        return this.getMonumentsListLiveData;
    }

    public void updateMonuments(final Context context){
        Call<List<Monument>> call = this.appService.getMonumentList();
        call.enqueue(new Callback<List<Monument>>() {
            @Override
            public void onResponse(Call<List<Monument>> call, Response<List<Monument>> response) {
                if (response.isSuccessful()){
                   final List<Monument> monumentList = response.body();
                    if (monumentList != null){
                        getMonumentsListLiveData.postValue(monumentList);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Monument>> call, Throwable t) {
                Log.e("menu", "an error occurred");
            }
        });
    }

    public LiveData<Monument> getMonument(final Context context, long id){
        MutableLiveData<Monument> monumentLiveData = new MutableLiveData<>();

        Call<Monument> call = appService.getMonument(id);
        call.enqueue(new Callback<Monument>() {
            @Override
            public void onResponse(Call<Monument> call, Response<Monument> response) {
                if (response.isSuccessful()){
                    final Monument monument = response.body();
                    if (monument != null)
                    monumentLiveData.postValue(monument);
                }
            }

            @Override
            public void onFailure(Call<Monument> call, Throwable t) {
                Log.e("Menu", "an error occurred");
            }
        });

        return monumentLiveData;
    }

    public LiveData<List<InterestPoint>> getInterestPointsByMonumentId(final long monumentId, final Context context) {
        MutableLiveData<List<InterestPoint>> pointsList = new MutableLiveData<>();
        Call<List<InterestPoint>> call = this.appService.getInterestPointsByMonumentId(monumentId);
        call.enqueue(new Callback<List<InterestPoint>>() {
            @Override
            public void onResponse(Call<List<InterestPoint>> call, Response<List<InterestPoint>> response) {
                if (response.isSuccessful()){
                    final List<InterestPoint> interestPointsList = response.body();
                    if (interestPointsList != null){
                        pointsList.postValue(interestPointsList);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<InterestPoint>> call, Throwable t) {
                Log.e("menu", "an error occurred");
            }
        });
        return pointsList;
    }

    public LiveData<InterestPoint> getIntetestPoint(long id, Context context) {
        MutableLiveData<InterestPoint> interestPointLiveData = new MutableLiveData<>();

        Call<InterestPoint> call = appService.getInterestPoint(id);
        call.enqueue(new Callback<InterestPoint>() {
            @Override
            public void onResponse(Call<InterestPoint> call, Response<InterestPoint> response) {
                if (response.isSuccessful()){
                    InterestPoint interestPoint = response.body();
                    interestPointLiveData.postValue(interestPoint);
                }
            }

            @Override
            public void onFailure(Call<InterestPoint> call, Throwable t) {
                Log.e("Menu", "an error occurred");
            }
        });
        return interestPointLiveData;
    }


}
