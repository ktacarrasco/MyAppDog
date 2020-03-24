package com.example.myappdog.view.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myappdog.R;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

public class AdapterFavoriteBreed  extends RecyclerView.Adapter<AdapterFavoriteBreed.ViewHolderPhotoFav> {

    private List<String> breedFav;
    private Context context;
    private ItemClick3 listener;
    private FirebaseFirestore db;

    public AdapterFavoriteBreed(List<String> breedFav, Context context, ItemClick3 listener) {
        this.breedFav = breedFav;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolderPhotoFav onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_fav, parent, false);


        return new ViewHolderPhotoFav(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPhotoFav holder, int position) {
        Log.e("POSITION", String.valueOf(position));
        String favoriteDog = breedFav.get(position);
        Log.e("POSITIONFAVORITE", String.valueOf(favoriteDog));

        Glide.with(holder.dogPhotoFav.getContext())
                .load(favoriteDog)
                .into(holder.dogPhotoFav);

    }

    @Override
    public int getItemCount() {
        return breedFav.size() ;
    }

    class ViewHolderPhotoFav extends RecyclerView.ViewHolder {
        private ImageView dogPhotoFav;

        public ViewHolderPhotoFav(@NonNull View itemView) {
            super(itemView);
            dogPhotoFav = itemView.findViewById(R.id.dogFavImage);

        }
    }

    public interface ItemClick3{


    }
}
