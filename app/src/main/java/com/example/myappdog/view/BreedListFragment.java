package com.example.myappdog.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myappdog.R;
import com.example.myappdog.presenter.IpresenterImage;
import com.example.myappdog.presenter.IpresenterList;
import com.example.myappdog.presenter.PresenterBreedList;
import com.example.myappdog.view.adapter.AdapterBreedList;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BreedListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BreedListFragment extends Fragment implements AdapterBreedList.ItemClick, IpresenterImage {

    private PresenterBreedList presenter;
    private AdapterBreedList adapter;
    private RecyclerView recyclerView;
    private List<String> doggis = new ArrayList<>();


    public BreedListFragment() {
        // Required empty public constructor
    }

    public static BreedListFragment newInstance() {
        BreedListFragment fragment = new BreedListFragment();
         return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new PresenterBreedList(this);
        presenter.loadBreedList();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_breed_list, container, false);
        recyclerView = view.findViewById(R.id.menuList);
        Log.e("ALGO OCUrre", String.valueOf(doggis.size()));
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        return view;

    }



    @Override
    public void onClick(String dog) {
        Toast.makeText(getContext(), dog, Toast.LENGTH_SHORT).show();
        presenter.loadImagesBreed(dog);
        showMessageInView(dog);
    }


    @Override
    public void showBreedList(List<String> dogBreedList) {
        adapter = new AdapterBreedList(dogBreedList, getContext(),this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showImagesUrlList(List<String> dogsUrlList) {
        Log.e("URL", dogsUrlList.toString());
        adapter = new AdapterBreedList(dogsUrlList, getContext(),this);
        recyclerView.setAdapter(adapter);

       // presenter.loadImagesBreed(dog);
        initializeFragmentBreed(dogsUrlList);
    }

    @Override
    public void showMessageInView(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    private void initializeFragmentBreed(List<String> urls) {
        BreedImageFragment breedImageListFragment = BreedImageFragment.newInstance(urls);
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameLf, breedImageListFragment, breedImageListFragment.getClass().getSimpleName())
                .addToBackStack("dog")
                .commit();
    }
}
