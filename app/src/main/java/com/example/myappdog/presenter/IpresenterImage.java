package com.example.myappdog.presenter;

import java.util.List;

public interface IpresenterImage {
    void showBreedList(List<String > dogBreedList);

    void showImagesUrlList(List<String> dogsUrlList);

    void showMessageInView(String message);
}
