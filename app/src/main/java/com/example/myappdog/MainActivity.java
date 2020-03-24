package com.example.myappdog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.myappdog.view.BreedListFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeFragmentBreed();


        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Abriendo Favoritos", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                getDogs();
            }
        });
    }

    private void getDogs() {

       /* db = FirebaseFirestore.getInstance();

        db.collection("favorito")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        ArrayList<String> favdoggis = new ArrayList<>();
                        Log.e("FAV1",String.valueOf(favdoggis));

                        if (task.isSuccessful()) {
                            Log.e("FAVIF",String.valueOf(favdoggis));
                            QuerySnapshot result = task.getResult();
                            List<DocumentSnapshot> data = result.getDocuments();
                            for (QueryDocumentSnapshot doc : task.getResult()) {
                                Log.e("FAV3", doc.getId() + " " + doc.getData());
                                favdoggis.add((String) doc.getData().get("url"));
                                Log.e("FAV2",String.valueOf(favdoggis));
                                instanceFavoriteDog(favdoggis);
                            }
                        } else {
                            Toast.makeText(MainActivity.this, "No se puede acceder a Favoritos", Toast.LENGTH_SHORT).show();
                        }
                    }


                });*/
    }


    private void initializeFragmentBreed() {
        BreedListFragment breedListFragment = BreedListFragment.newInstance();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frameLf, breedListFragment, breedListFragment.getClass().getSimpleName())
                .commit();
    }


}