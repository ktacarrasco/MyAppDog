package com.example.myappdog.presenter;

import android.util.Log;

import com.example.myappdog.model.BreedImageListResponse;
import com.example.myappdog.model.BreedListResponse;
import com.example.myappdog.model.apiDog.Api;
import com.example.myappdog.model.apiDog.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PresenterBreedList implements IpresenterList {

    IpresenterImage view;
    Api service = RetrofitClient.getRetrofitInstance().create(Api.class);
    Call<BreedListResponse> call = service.getBreedList();

    public PresenterBreedList(IpresenterImage view) {
        this.view = view;
    }


    @Override
    public void loadBreedList() {

        call.enqueue(new Callback<BreedListResponse>() {
            @Override
            public void onResponse(Call<BreedListResponse> call, Response<BreedListResponse> response) {

                if (response.body() != null) {
                    List<String> doggis = response.body().getBreedList();
                    Log.e("DATOS",String.valueOf(doggis));
                    view.showBreedList(doggis);
                }
            }
            @Override
            public void onFailure(Call<BreedListResponse> call, Throwable t) {
                Log.e("ERROR", String.valueOf(t));
                view.showMessageInView(t.toString());
            }
        });

    }

    @Override
    public void loadImagesBreed(String dogBreed) {


        Call<BreedImageListResponse> callImages = service.getBreedImageList(dogBreed);
        Log.e("IMAGENES", String.valueOf(dogBreed));
        callImages.enqueue(new Callback<BreedImageListResponse>() {
            @Override
            public void onResponse(Call<BreedImageListResponse> call, Response<BreedImageListResponse> response) {
                List<String> imagesURL = response.body().getImageURL();
                Log.e("IMAGESDOGS", String.valueOf(imagesURL));
                view.showImagesUrlList(imagesURL);

            }

            @Override
            public void onFailure(Call<BreedImageListResponse> call, Throwable t) {
                Log.e("FALLO", String.valueOf(t));
            }

        });
    }


}
