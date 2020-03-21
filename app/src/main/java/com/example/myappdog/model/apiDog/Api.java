package com.example.myappdog.model.apiDog;

import com.example.myappdog.model.BreedImageListResponse;
import com.example.myappdog.model.BreedListResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Api {


    @GET("api/breeds/list")
    Call<BreedListResponse> getBreedList();


    @GET("api/breed/{breed}/images/")
    Call<BreedImageListResponse>getBreedImageList(@Path("breed") String breed);
}
