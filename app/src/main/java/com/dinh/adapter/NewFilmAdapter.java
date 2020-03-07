package com.dinh.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.dinh.activity.InfoVideoDetailActivity;
import com.dinh.activity.R;
import com.dinh.model.Product;

import java.util.List;

public class NewFilmAdapter extends RecyclerView.Adapter<NewFilmAdapter.ViewHolder> {
    List<Product> listNewFilm;
    Context context;

    public NewFilmAdapter(List<Product> listNewFilm, Context context) {
        this.listNewFilm = listNewFilm;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.custom_item_new_film, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = listNewFilm.get(position);
        Glide.with(context).load(product.getProductImage()).into(holder.img_item_new_film);
    }

    @Override
    public int getItemCount() {
        return listNewFilm.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView img_item_new_film;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_item_new_film = itemView.findViewById(R.id.img_item_new_film);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getLayoutPosition();
            Product newfilm = listNewFilm.get(position);
            Toast.makeText(context, "" + newfilm.getProductName(), Toast.LENGTH_SHORT).show();
//            Intent intent = new Intent(v.getContext(), InfoVideoDetailActivity.class);
//
//            Bundle bundle = new Bundle();
//            bundle.putSerializable("NEWFILM", newfilm);
//            intent.putExtras(bundle);
//            context.startActivity(intent);
        }
    }
}
