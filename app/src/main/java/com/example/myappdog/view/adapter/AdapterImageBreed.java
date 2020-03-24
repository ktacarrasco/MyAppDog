package com.example.myappdog.view.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myappdog.R;
import com.example.myappdog.model.apiDog.FavoriteDog;
import com.example.myappdog.view.BreedImageFragment;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

public class AdapterImageBreed extends RecyclerView.Adapter<AdapterImageBreed.ViewHolderPhoto> {

    private List<String> breedPhoto;
    private Context context;
    private ItemClick2 listener;
    private FirebaseFirestore db;

    public AdapterImageBreed(List<String> breedPhoto, Context context, BreedImageFragment listener) {
        this.breedPhoto = breedPhoto;
        this.context = context;
        this.listener = (ItemClick2) listener;
    }

    @NonNull
    @Override
    public ViewHolderPhoto onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_photo, parent, false);

        return new ViewHolderPhoto(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPhoto holder, final int position) {
        Log.e("POSITION", String.valueOf(position));
        String breedPhotoListResponse = breedPhoto.get(position);
        Log.e("POSITIONRESPONSE", String.valueOf(breedPhotoListResponse));

        Glide.with(holder.dogPhotoView.getContext())
                .load(breedPhotoListResponse)
                .into(holder.dogPhotoView);


        holder.dogPhotoView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                db = FirebaseFirestore.getInstance();
                final int x = 0;
                FavoriteDog selectFav = new FavoriteDog(breedPhoto.get(position), Timestamp.now());
                try {
                    db.collection("favorito").add(selectFav);
                    Log.e("CONT", String.valueOf(selectFav));
                    Toast.makeText(context, "Foto enviada a favorito", Toast.LENGTH_SHORT).show();

                    return true;
                } catch(Exception e) {
                    Toast.makeText(context, "Fallo al intentar guardar la foto", Toast.LENGTH_SHORT).show();
                    return false;
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return breedPhoto.size();
    }


    class ViewHolderPhoto extends RecyclerView.ViewHolder {
        private ImageView dogPhotoView;
        public ViewHolderPhoto(@NonNull View itemView) {
            super(itemView);
            dogPhotoView = itemView.findViewById(R.id.dogImage);

        }
    }

    public interface ItemClick2{


    }
}
