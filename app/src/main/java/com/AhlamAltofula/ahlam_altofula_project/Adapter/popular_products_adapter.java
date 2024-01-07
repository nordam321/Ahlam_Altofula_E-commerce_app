package com.AhlamAltofula.ahlam_altofula_project.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.AhlamAltofula.ahlam_altofula_project.Activities.RecyclerViewInterface;
import com.AhlamAltofula.ahlam_altofula_project.R;
import com.AhlamAltofula.ahlam_altofula_project.Models.popular_products_model;

import java.util.ArrayList;

public class popular_products_adapter  extends RecyclerView.Adapter<popular_products_adapter.MyViewHolder> {
    private final RecyclerViewInterface recyclerViewInterface;
    Context context;
    ArrayList<popular_products_model> items;

    public popular_products_adapter(Context context, ArrayList<popular_products_model> items,RecyclerViewInterface recyclerViewInterface) {
        this.context = context;
        this.items = items;
        this.recyclerViewInterface=recyclerViewInterface;
    }

    @NonNull
    @Override
    public popular_products_adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.viewholder_pup_list,parent,false);
        return new  popular_products_adapter.MyViewHolder(view,recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull popular_products_adapter.MyViewHolder holder, int position) {
        holder.title.setText(items.get(position).getTitle());
        holder.price.setText("$" + items.get(position).getPrice());
        holder.pic.setImageResource(items.get(position).getImages());
    }

    @Override
    public int getItemCount() {

        return items.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title,price;
        ImageView pic;

        public MyViewHolder(@NonNull View itemView,RecyclerViewInterface recyclerViewInterface) {
            super(itemView);
                title = itemView.findViewById(R.id.title);
                price = itemView.findViewById(R.id.price);
                pic = itemView.findViewById(R.id.pic);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(recyclerViewInterface != null){
                        int pos = getAdapterPosition();
                        if (pos != RecyclerView.NO_POSITION){
                            recyclerViewInterface.onItemClick(pos);
                        }
                    }
                }
            });
        }
    }
}
