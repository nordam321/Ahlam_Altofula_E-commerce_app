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
import com.AhlamAltofula.ahlam_altofula_project.Models.boy_products_model;
import com.AhlamAltofula.ahlam_altofula_project.R;

import java.util.ArrayList;

public class boy_products_adapter extends RecyclerView.Adapter<boy_products_adapter.MyViewHolder> {

    Context context;
    ArrayList<boy_products_model> items;
    private final RecyclerViewInterface recyclerViewInterface;

    public boy_products_adapter(Context context,ArrayList<boy_products_model> items ,RecyclerViewInterface recyclerViewInterface) {
        this.context = context;
        this.items = items;
        this.recyclerViewInterface =recyclerViewInterface;
    }
    @NonNull
    @Override
    public boy_products_adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.viewholder_boy_girl_category,parent,false);
        return new boy_products_adapter.MyViewHolder(view,recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull boy_products_adapter.MyViewHolder holder, int position) {
        holder.titleTv.setText(items.get(position).getTitle());
        holder.priceTv.setText("$" + items.get(position).getPrice());
        holder.pic.setImageResource(items.get(position).getPic());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView titleTv,priceTv;
        ImageView pic;
        public MyViewHolder(@NonNull View itemView ,RecyclerViewInterface recyclerViewInterface) {
            super(itemView);
            titleTv = itemView.findViewById(R.id.titleTv);
            priceTv = itemView.findViewById(R.id.priceTv);
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
