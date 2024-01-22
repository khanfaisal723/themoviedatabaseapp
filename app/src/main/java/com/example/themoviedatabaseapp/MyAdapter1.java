package com.example.themoviedatabaseapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class MyAdapter1 extends RecyclerView.Adapter<MyAdapter1.MYV1> {

    List<String> list = Arrays.asList("first", "second", "third", "fourth", "fifth", "first", "second", "third", "fourth", "fifth", "first", "second", "third", "fourth", "fifth");
    List<JsonPOJO.Result> results;

    public MyAdapter1(List<JsonPOJO.Result> results) {
        this.results = results;
    }


    @NonNull
    @Override
    public MYV1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_data, parent, false);
        return new MYV1(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MYV1 holder, int position) {


        if (results != null) {
            holder.textView.setText(results.get(position).getTitle());
            holder.imageView.animate();

        }else {
        holder.textView.setText(list.get(position));
    }

    }

    @Override
    public int getItemCount() {
        if (results != null) {
        return results.size();}else {
            return list.size();
        }
    }

    public class MYV1 extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;

        public MYV1(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv1);
            imageView = itemView.findViewById(R.id.img);

        }
    }
}
