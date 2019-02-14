package com.trevorpc.newstart.model;

import android.Manifest;
import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

import com.trevorpc.newstart.web.IMyAPI;
import com.trevorpc.newstart.web.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class ResponseRepository {
    private IMyAPI api;
    private List<Response> responses;
    private static final String TAG = "TAG";

    public ResponseRepository(Application application) {
        RetrofitClient client = new RetrofitClient();
        Retrofit retrofit = client.getOurInstance();
        api = retrofit.create(IMyAPI.class);

    }

    public List<Response> getResponses() {
        return responses;
    }

    public void fetchData(Double latitude, Double longitude)
    {
        api.getResponse(latitude,longitude,20)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<FullResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "onSubscribe: ");
                    }

                    @Override
                    public void onSuccess(FullResponse fullResponse) {
                        Log.d(TAG, "onSuccess: ");
                        responses = fullResponse.getResponse();
                        Log.d(TAG, "onSuccess: "+ responses.get(1).getDuration());

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: ");
                    }
                });


    }


}
