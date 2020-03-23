package com.example.myappdog.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myappdog.R;

import java.util.List;

public class AdapterBreedList extends RecyclerView.Adapter<AdapterBreedList.ViewHolderList> {

    private List<String> breedList;
    private Context context;
    private ItemClick listener;

    public AdapterBreedList(List<String> breedList, Context context, ItemClick listener) {
        this.breedList = breedList;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolderList onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, parent, false);


        return new ViewHolderList(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderList holder, final int position) {
        holder.textViewitem.setText(breedList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(breedList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return breedList.size();
    }

    class  ViewHolderList extends RecyclerView.ViewHolder {
        private TextView textViewitem;

        public ViewHolderList(@NonNull View itemView) {
            super(itemView);
            textViewitem = itemView.findViewById(R.id.textViewitem);
        }
    }

    public interface ItemClick {
        void onClick(String dog);
    }
}
