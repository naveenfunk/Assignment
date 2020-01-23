package com.assignment.networking;

import com.assignment.models.HitsJson;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIs {

    @GET("search_by_date?tags=story")
    Call<HitsJson> getHitList(
            @Query("page") int page
    );
}
