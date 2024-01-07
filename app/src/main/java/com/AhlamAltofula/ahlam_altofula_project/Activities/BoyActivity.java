package com.AhlamAltofula.ahlam_altofula_project.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.AhlamAltofula.ahlam_altofula_project.Models.boy_products_model;
import com.AhlamAltofula.ahlam_altofula_project.Adapter.boy_products_adapter;
import com.AhlamAltofula.ahlam_altofula_project.R;

import java.util.ArrayList;


public class BoyActivity extends AppCompatActivity implements RecyclerViewInterface{
    RecyclerView boyRecyclerView;
    Button homeBtn,cartBtn;
    ImageView backBtn;
    ArrayList<boy_products_model> items = new ArrayList<>();
    int[] boy_item_images = {R.drawable.boy_product1,R.drawable.boy_product2,R.drawable.boy_product3,R.drawable.boy_product4,
            R.drawable.boy_product5,R.drawable.boy_product6};
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boy);
        IniVariable();
        IniMenuButtons();
        setPopularProductsModels();
        boy_products_adapter adapter = new boy_products_adapter(this,items,this);
        boyRecyclerView.setAdapter(adapter);
        boyRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void setPopularProductsModels(){
        String[] boy_products_name = getResources().getStringArray(R.array.boy_products_title);
        String[] boy_products_description = getResources().getStringArray(R.array.boy_products_description);
        int[] boy_products_price = getResources().getIntArray(R.array.boy_products_price);
        for(int i = 0; i<boy_item_images.length;i++){
            items.add(new boy_products_model(boy_products_name[i],boy_products_price[i],boy_item_images[i] ,boy_products_description[i]));
        }
    }
    private void IniVariable(){
        boyRecyclerView = findViewById(R.id.boyRecyclerView);
        backBtn = findViewById(R.id.backBtn);
        cartBtn = findViewById(R.id.cartBtn);
        homeBtn = findViewById(R.id.homeBtn);
    }
    private void IniMenuButtons(){
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BoyActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BoyActivity.this,CartActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(BoyActivity.this,DetailActivity.class);
        intent.putExtra("TITLE", items.get(position).getTitle());
        intent.putExtra("PRICE", items.get(position).getPrice());
        intent.putExtra("DESCRIPTION", items.get(position).getDis());
        intent.putExtra("IMAGE", items.get(position).getPic());
        startActivity(intent);
    }
}
