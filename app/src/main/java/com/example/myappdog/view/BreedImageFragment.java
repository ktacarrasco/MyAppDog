package com.example.myappdog.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myappdog.R;
import com.example.myappdog.presenter.PresenterBreedList;
import com.example.myappdog.view.adapter.AdapterBreedList;
import com.example.myappdog.view.adapter.AdapterImageBreed;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BreedImageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BreedImageFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private PresenterBreedList presenter;
    private AdapterBreedList adapter;
    private RecyclerView recyclerView;
    private List<String> doggis = new ArrayList<>();

    public BreedImageFragment() {
        // Required empty public constructor
    }

    public static BreedImageFragment newInstance(List<String> urlList) {

        BreedImageFragment fragment = new BreedImageFragment();
        Bundle args = new Bundle();
        args.putStringArrayList(ARG_PARAM1, (ArrayList<String>) urlList);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            doggis = getArguments().getStringArrayList(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       // View view = inflater.inflate(R.layout.fragment_breed_list, container, false);
        //TextView textViewImages = view.findViewById(R.id.textViewitem);
        //textViewImages.setText(mParam1.get(0).toString());
        View view =  inflater.inflate(R.layout.fragment_breed_image, container, false);
        //ArrayList<String> doggis = getArguments().getStringArrayList("ARG_PARAM1");
        recyclerView = view.findViewById(R.id.menuPhotoList);
        Log.e("ALGO OCUrre", String.valueOf(doggis.size()));
        //adapter = new AdapterImageBreed(doggis, view.getContext(),this);
       // recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        return view;



    }
}
