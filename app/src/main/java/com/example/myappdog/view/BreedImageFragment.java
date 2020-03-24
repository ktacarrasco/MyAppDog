package com.example.myappdog.view;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myappdog.R;
import com.example.myappdog.model.apiDog.FavoriteDog;
import com.example.myappdog.presenter.IpresenterImage;
import com.example.myappdog.presenter.PresenterBreedList;
import com.example.myappdog.view.adapter.AdapterBreedList;
import com.example.myappdog.view.adapter.AdapterImageBreed;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BreedImageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BreedImageFragment extends Fragment  implements AdapterImageBreed.ItemClick2, IpresenterImage {
    private static final String ARG_PARAM1 = "param1";
    private PresenterBreedList presenter;
    private AdapterImageBreed adapter;
    private RecyclerView recyclerView;
    private List<String> doggis = new ArrayList<>();
    private List<String> breedPhoto;
    private Context context;
    private FirebaseFirestore db;

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

        View view =  inflater.inflate(R.layout.fragment_breed_image, container, false);

        recyclerView = view.findViewById(R.id.menuPhotoList);
        Log.e("ALGO OCUrre", String.valueOf(doggis.size()));
        adapter = new AdapterImageBreed(doggis, view.getContext(),this);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);



        return view;

    }

    @Override
    public void showBreedList(List<String> dogBreedList) {

    }

    @Override
    public void showImagesUrlList(List<String> dogsUrlList) {

    }

    @Override
    public void showMessageInView(String message) {

    }
}
