package com.app.danvinetechnologies.skoolmate;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SimpleAdapter extends  RecyclerView.Adapter<SimpleAdapter.SimpleViewHolder>{


    List<Integer> list;
    public SimpleAdapter() {

        list = new ArrayList<>();
        for(int i=0;i<=5;i++)
            list.add(i);
    }

    @NonNull
    @Override
    public SimpleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_item,viewGroup,false);
        return new SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SimpleViewHolder simpleViewHolder, int i) {

        simpleViewHolder.textView.setText(String.valueOf(list.get(i)));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class SimpleViewHolder extends RecyclerView.ViewHolder{


        public TextView textView;
        public SimpleViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textview);
        }
    }
}
