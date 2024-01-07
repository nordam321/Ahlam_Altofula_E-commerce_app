package com.AhlamAltofula.ahlam_altofula_project.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.AhlamAltofula.ahlam_altofula_project.SharedPreference.ManagmentCart;
import com.AhlamAltofula.ahlam_altofula_project.Adapter.cart_products_adapter;
import com.AhlamAltofula.ahlam_altofula_project.Models.cart_products_model;
import com.AhlamAltofula.ahlam_altofula_project.R;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ImageView backBtn;
    Button buyNowBtn,homeBtn,cartBtn;
    ManagmentCart managmentCart;
    TextView subtotalTv,totalTaxTv,deliveryTv,totalTv;
    ArrayList<cart_products_model> cartList;
    double percentTax = 0.02;
    double delivery = 10 ;
    double tax = 0;
    double total = 0;
    //String whatsappUser = "+9005388647079";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        managmentCart = new ManagmentCart(CartActivity.this);

        IniVariable();
        calculateCart();
        IniMenuButtons();
        cart_products_adapter adapter = new cart_products_adapter(this,managmentCart.getListCart());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        backBtn.setOnClickListener(v -> finish());
        buyNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String url = "https://api.whatsapp.com/send?phone=" + whatsappUser  +"&text=" + URLEncoder.encode("hi", "UTF-8"); ;
//                try {
//                    PackageManager pm = getApplicationContext().getPackageManager();
//                    pm.getPackageInfo("com.whatsapp" , PackageManager.GET_ACTIVITIES);
//                    Intent intent = new Intent(Intent.ACTION_VIEW);
//                    intent.setData(Uri.parse(url));
//
//                    startActivity(intent);
//                } catch (PackageManager.NameNotFoundException e) {
//                    startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse(url
//                    )));
//                }
                try {
                    String toNumber = "+90 5388647079"; // contains spaces.
                    toNumber = toNumber.replace("+", "").replace(" ", "");

                    Intent sendIntent = new Intent("android.intent.action.MAIN");
                    sendIntent.putExtra("jid", toNumber + "@s.whatsapp.net");
                    sendIntent.putExtra(Intent.EXTRA_TEXT, "Hi, I ordered through AHLAM ALTOFULA program and my order is \n" +managmentCart.getOrder() +"\n"
                            + "Subtotal = $" + managmentCart.getSubTotal()  +"\n"+ "Delivery = $" + delivery  +"\n"+ "Total Tax = $" + tax +"\n"+ "Total = $" + total +"\n");
                    sendIntent.setAction(Intent.ACTION_SEND);
                    sendIntent.setPackage("com.whatsapp");
                    sendIntent.setType("text/plain");
                    startActivity(sendIntent);
                }
                catch (android.content.ActivityNotFoundException E){
                    Toast.makeText(CartActivity.this,"you dont have whatsapp in your phoneee",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    private void calculateCart() {
        double subtotal = managmentCart.getSubTotal() ;
        tax = subtotal * percentTax;
        total = delivery + subtotal + tax;
        totalTaxTv.setText("$" + tax);
        subtotalTv.setText("$" + subtotal);
        deliveryTv.setText("$" + delivery);
        totalTv.setText("$" + total);
        refresh(100);
    }
    private void refresh(int millisecond){
        final Handler handler = new Handler();
        final  Runnable runnable = new Runnable() {
            @Override
            public void run() {
                calculateCart();
            }
        };
        handler.postDelayed(runnable,millisecond);
    }
    private void IniVariable(){
        recyclerView = findViewById(R.id.cartRecyclerView);
        backBtn = findViewById(R.id.backBtn);
        subtotalTv = findViewById(R.id.subtotalTv);
        totalTv = findViewById(R.id.totalTv);
        totalTaxTv = findViewById(R.id.totalTaxTv);
        deliveryTv = findViewById(R.id.deliveryTv);
        buyNowBtn = findViewById(R.id.buyNowBtn);
        cartBtn = findViewById(R.id.cartBtn);
        homeBtn = findViewById(R.id.homeBtn);
        //cartList = (ArrayList<cart_products_model>) PrefConfig.readListFromPref(CartActivity.this);
    }
    private void IniMenuButtons(){
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CartActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CartActivity.this,"You are already on the shopping cart page",Toast.LENGTH_SHORT).show();
            }
        });
    }


//    private void setPopularProductsModels(String getTitle){
//        String[] popular_products_name = getResources().getStringArray(R.array.popular_products_title);
//        String[] popular_products_price = getResources().getStringArray(R.array.popular_products_price);
//            for(int i = 0; i<popular_products_name.length;i++){
//                if(getTitle.equals(popular_products_name[i])){
//                    items1.add(new cart_products_model(popular_products_name[i],popular_products_price[i],iteam_images[i]));
//                    break;
//                }
//            }
//    }
}