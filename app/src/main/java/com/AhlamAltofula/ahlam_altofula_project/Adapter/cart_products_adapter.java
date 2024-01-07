package com.AhlamAltofula.ahlam_altofula_project.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.AhlamAltofula.ahlam_altofula_project.SharedPreference.ManagmentCart;
import com.AhlamAltofula.ahlam_altofula_project.Models.cart_products_model;
import com.AhlamAltofula.ahlam_altofula_project.R;

import java.util.ArrayList;

public class cart_products_adapter extends RecyclerView.Adapter<cart_products_adapter.MyViewHolder> {
    Context context;
    ArrayList<cart_products_model> items;
    ManagmentCart managmentCart;

    public cart_products_adapter(Context context,ArrayList<cart_products_model> items) {
        this.context = context;
        managmentCart = new ManagmentCart(context);
        this.items = items;
    }

    @NonNull
    @Override
    public cart_products_adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.viewholder_cart,parent,false);
        return new cart_products_adapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull cart_products_adapter.MyViewHolder holder, int position) {
        holder.titleTv.setText(items.get(position).getTitle());
        holder.priceTv.setText("$" +items.get(position).getPrice());
        holder.pic.setImageResource(items.get(position).getPic());

        holder.remove.setOnClickListener(v -> {
            managmentCart.removeItem(items,position);
            notifyDataSetChanged();
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView titleTv,priceTv;
        ImageView pic,remove;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTv = itemView.findViewById(R.id.titleTv);
            priceTv = itemView.findViewById(R.id.priceTv);
            pic = itemView.findViewById(R.id.pic);
            remove = itemView.findViewById(R.id.remove);
        }
    }
}
