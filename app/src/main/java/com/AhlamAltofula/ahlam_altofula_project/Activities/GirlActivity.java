package com.AhlamAltofula.ahlam_altofula_project.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.AhlamAltofula.ahlam_altofula_project.Adapter.girl_products_adapter;
import com.AhlamAltofula.ahlam_altofula_project.Models.girl_products_model;
import com.AhlamAltofula.ahlam_altofula_project.R;

import java.util.ArrayList;


public class GirlActivity extends AppCompatActivity  implements RecyclerViewInterface{
    RecyclerView girlRecyclerView;
    Button homeBtn,cartBtn;
    ImageView backBtn;
    ArrayList<girl_products_model> items = new ArrayList<>();
    int[] girl_item_images = {R.drawable.girl_product1,R.drawable.girl_product2,R.drawable.girl_product3,R.drawable.girl_product4
                            ,R.drawable.girl_product5,R.drawable.girl_product6,R.drawable.girl_product7};
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_girl);
        IniVariable();
        IniMenuButtons();
        setPopularProductsModels();
        girl_products_adapter adapter = new girl_products_adapter(this,items,this);
        girlRecyclerView.setAdapter(adapter);
        girlRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void setPopularProductsModels(){
        String[] girl_products_name = getResources().getStringArray(R.array.girl_products_title);
        int[] girl_products_price = getResources().getIntArray(R.array.girl_products_price);
        for(int i = 0; i<girl_item_images.length;i++){
            items.add(new girl_products_model(girl_products_name[i],girl_products_price[i],girl_item_images[i]));
        }
    }
    private void IniVariable(){
        girlRecyclerView = findViewById(R.id.girlRecyclerView);
        backBtn = findViewById(R.id.backBtn);
        cartBtn = findViewById(R.id.cartBtn);
        homeBtn = findViewById(R.id.homeBtn);
    }
    private void IniMenuButtons(){
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GirlActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GirlActivity.this,CartActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(GirlActivity.this,DetailActivity.class);
        intent.putExtra("TITLE", items.get(position).getTitle());
        intent.putExtra("PRICE", items.get(position).getPrice());
        intent.putExtra("IMAGE", items.get(position).getPic());
        startActivity(intent);
    }
}
