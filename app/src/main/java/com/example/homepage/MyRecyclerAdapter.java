package com.example.homepage;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MyRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ArrayList<DataFile> allcount;
    onClickInterface onClickinterface;

    public MyRecyclerAdapter(Context context, ArrayList<DataFile> allcount,onClickInterface onClickinterface) {
        this.context = context;
        this.allcount = allcount;
        this.onClickinterface = onClickinterface;
    }

    @NonNull

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final DataFile dataFile = allcount.get(position);
        ViewHolder itemholder = (ViewHolder) holder;
        itemholder.name.setText(dataFile.getName());
        itemholder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii = new Intent(context, AllInfo.class);
                for (int i = 0; i < allcount.size(); i++) {
                    if (itemholder.name.getText() == allcount.get(i).getName()) {
                        ii.putExtra("nam", allcount.get(i).getName());
                        ii.putExtra("cap", allcount.get(i).getCapital());
                        ii.putExtra("reg", allcount.get(i).getRegion());
                        ii.putExtra("subreg", allcount.get(i).getSubregion());
                        ii.putExtra("pop1", String.valueOf(allcount.get(i).getPopu()));
                    }
                }
                context.startActivity(ii);
            }
        });
    }

    @Override
    public int getItemCount() {
        return allcount.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
        }
    }
}
