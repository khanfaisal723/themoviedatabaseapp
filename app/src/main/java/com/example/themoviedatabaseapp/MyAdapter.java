package com.example.themoviedatabaseapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyVH> {
    Context context;

    List<String> list1 = Arrays.asList("New", "Popular", "Upcoming", "Trailer");
    List<JsonPOJO.Result> results;


    public MyAdapter(Context context, List<JsonPOJO.Result> results) {
        this.context = context;
        this.results = results;

    }


    @NonNull
    @Override
    public MyVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_layout, parent, false);
        return new MyVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyVH holder, int position) {
        LinearLayoutManager layoutManager =
                new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        holder.recyclerView.setLayoutManager(layoutManager);
        holder.recyclerView.setAdapter(new MyAdapter1(results));
        holder.recyclerView.hasFixedSize();
        holder.textView.setText(list1.get(position));

    }

    @Override
    public int getItemCount() {
        return list1.size();
    }

    public static class MyVH extends RecyclerView.ViewHolder {

        RecyclerView recyclerView;
        TextView textView;

        public MyVH(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.rv1);
            textView = itemView.findViewById(R.id.tview);

        }
    }
}