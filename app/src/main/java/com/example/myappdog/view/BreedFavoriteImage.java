package com.example.myappdog.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myappdog.R;
import com.example.myappdog.view.adapter.AdapterFavoriteBreed;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BreedFavoriteImage#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BreedFavoriteImage extends Fragment implements  AdapterFavoriteBreed.ItemClick3 {
    private static final String ARG_PARAM1 = "param1";
    private ArrayList<String> mParam1;


    private AdapterFavoriteBreed adapter;
    private RecyclerView recyclerView;

    List<String> doggis = new ArrayList<>();

    public BreedFavoriteImage() {
        // Required empty public constructor
    }
    public static BreedFavoriteImage newInstance(List<String> param1) {
        BreedFavoriteImage fragment = new BreedFavoriteImage();
        Bundle args = new Bundle();
        args.putStringArrayList(ARG_PARAM1, (ArrayList<String>) param1);
        fragment.setArguments(args);
        return fragment;


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getStringArrayList(ARG_PARAM1);
            doggis = mParam1;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_breed_favorite_image, container, false);

        recyclerView = view.findViewById(R.id.menuFavList);
        Log.e("ALGO OCUrre", String.valueOf(doggis.size()));
        adapter = new AdapterFavoriteBreed(doggis, getContext(),this);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        return view;
    }
}
