package com.example.myappdog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.myappdog.view.BreedListFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeFragmentBreed();


    }

    private void initializeFragmentBreed() {
        BreedListFragment breedListFragment = BreedListFragment.newInstance();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frameLf, breedListFragment, breedListFragment.getClass().getSimpleName())
                .commit();
    }
}
