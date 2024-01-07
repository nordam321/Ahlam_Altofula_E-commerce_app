package com.AhlamAltofula.ahlam_altofula_project.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.AhlamAltofula.ahlam_altofula_project.R;
import com.AhlamAltofula.ahlam_altofula_project.Adapter.popular_products_adapter;
import com.AhlamAltofula.ahlam_altofula_project.Models.popular_products_model;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface {
    ArrayList<popular_products_model> items = new ArrayList<>();
    int[] iteam_images = {R.drawable.boy_product1,R.drawable.boy_product2,R.drawable.boy_product3,R.drawable.boy_product4,
                          R.drawable.boy_product5,R.drawable.girl_product1,R.drawable.girl_product2,R.drawable.girl_product3,
                          R.drawable.girl_product4};
    RecyclerView recyclerView;
    Button cartBtn,homeBtn;
    ImageView boyBtn,girlBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        IniButtonsAndImagesButtons();
        setPopularProductsModels();
        popular_products_adapter adapter = new popular_products_adapter(this,items,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
    }

    private void initView(){
        recyclerView = findViewById(R.id.pRecyclerView);
        cartBtn = findViewById(R.id.cartBtn);
        boyBtn = findViewById(R.id.boyBtn);
        girlBtn = findViewById(R.id.girlBtn);
        homeBtn = findViewById(R.id.homeBtn);
    }
    private void setPopularProductsModels(){
        String[] popular_products_name = getResources().getStringArray(R.array.popular_products_title);
        String[] popular_products_description = getResources().getStringArray(R.array.popular_products_description);
        int[] popular_products_price = getResources().getIntArray(R.array.popular_products_price);
        for(int i = 0; i<popular_products_name.length;i++){
            items.add(new popular_products_model(popular_products_name[i],popular_products_description[i],popular_products_price[i],iteam_images[i]));
        }
    }
    private void IniButtonsAndImagesButtons(){
        boyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BoyActivity.class);
                startActivity(intent);
            }
        });
        girlBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GirlActivity.class);
                startActivity(intent);
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"You are already on the Main page",Toast.LENGTH_SHORT).show();

            }
        });
        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,CartActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(MainActivity.this,DetailActivity.class);
        intent.putExtra("TITLE", items.get(position).getTitle());
        intent.putExtra("PRICE", items.get(position).getPrice());
        intent.putExtra("DESCRIPTION", items.get(position).getDescription());
        intent.putExtra("IMAGE", items.get(position).getImages());
        startActivity(intent);
    }

}