package com.AhlamAltofula.ahlam_altofula_project.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.AhlamAltofula.ahlam_altofula_project.SharedPreference.ManagmentCart;
import com.AhlamAltofula.ahlam_altofula_project.Models.cart_products_model;
import com.AhlamAltofula.ahlam_altofula_project.R;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity{
    cart_products_model objectAdd;
    private ManagmentCart managmentCart;
    Button addToCartBtn,homeBtn,cartBtn;;
    ImageView backBtn,image;
    TextView price,title,description;
    ArrayList<cart_products_model> cartList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        managmentCart = new ManagmentCart(DetailActivity.this);

        IniVariable();
        IniMenuButtons();
        getBundle();


    }
    private void IniVariable(){
        cartList = new ArrayList<>();
        description = findViewById(R.id.description);
        title = findViewById(R.id.title);
        price = findViewById(R.id.price);
        image = findViewById(R.id.itemPic);
        backBtn = findViewById(R.id.backBtn);
        addToCartBtn = findViewById(R.id.addToCartBt);
        cartBtn = findViewById(R.id.cartBtn);
        homeBtn = findViewById(R.id.homeBtn);
    }
    private void IniMenuButtons(){
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this,CartActivity.class);
                startActivity(intent);
            }
        });
    }


    private void getBundle(){
        String getTitle = getIntent().getStringExtra("TITLE");
        String getDescription = getIntent().getStringExtra("DESCRIPTION");
        int getPrice = getIntent().getIntExtra("PRICE" , 0);
        int getImage = getIntent().getIntExtra("IMAGE",0);
        title.setText(getTitle);
        description.setText(getDescription);
        price.setText("$" +getPrice);
        image.setImageResource(getImage);
        //object = (cart_products_model) getIntent().getSerializableExtra("object");
        addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                objectAdd = new cart_products_model(getTitle,getPrice,getImage);
                managmentCart.insertFood(objectAdd);
//             cartList.add(new cart_products_model(getTitle,getPrice,getImage));
//             PrefConfig.writeListInPref(getApplicationContext(),cartList);
//             Toast.makeText(DetailActivity.this,"Add to cart Successfully",Toast.LENGTH_SHORT).show();
            }
        });
        backBtn.setOnClickListener(v -> finish());

    }
}
