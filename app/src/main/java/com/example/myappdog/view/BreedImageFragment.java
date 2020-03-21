package com.example.myappdog.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myappdog.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BreedImageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BreedImageFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private List<String> mParam1;

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
            mParam1 = getArguments().getStringArrayList(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_breed_list, container, false);
        TextView textViewImages = view.findViewById(R.id.textViewitem);
        textViewImages.setText(mParam1.get(0).toString());
        return view;
    }
}
