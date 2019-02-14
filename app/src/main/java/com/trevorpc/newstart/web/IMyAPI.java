package com.trevorpc.newstart.web;

import com.trevorpc.newstart.model.FullResponse;


import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface IMyAPI {

    @GET("iss-pass.json")
    Single<FullResponse> getResponse(
            @Query("lat") double latitude,
            @Query("lon") double longitude,
            @Query("n") int number);

}


