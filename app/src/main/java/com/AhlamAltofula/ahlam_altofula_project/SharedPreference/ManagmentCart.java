package com.AhlamAltofula.ahlam_altofula_project.SharedPreference;

import android.content.Context;
import android.widget.Toast;

import com.AhlamAltofula.ahlam_altofula_project.Models.cart_products_model;

import java.util.ArrayList;

public class ManagmentCart {
    private Context context;
    private TinyDB tinyDB;

    public ManagmentCart(Context context) {
        this.context = context;
        this.tinyDB = new TinyDB(context);
    }
    public void insertFood(cart_products_model item){
        ArrayList<cart_products_model> listpop = getListCart();
        listpop.add(item);
        tinyDB.putListObject("CartList",listpop);
        Toast.makeText(context,"Add to cart Successfully",Toast.LENGTH_SHORT).show();
    }
    public int getSubTotal(){
        ArrayList<cart_products_model> listItem = getListCart();
        int subTotal = 0;
        for (int i = 0 ; i<listItem.size();i++){
            subTotal =subTotal +(listItem.get(i).getPrice());
        }
        return subTotal;
    }
    public void removeItem(ArrayList<cart_products_model> listItem,int position){
       listItem.remove(position);
        tinyDB.putListObject("CartList",listItem);

    }
    public String getOrder(){
        ArrayList<cart_products_model> listItem = getListCart();
        String item = "";
        for (int i = 0 ; i<listItem.size();i++){
            item =item+ (i+1) + "-" +(listItem.get(i).getTitle()) + "   $" + (listItem.get(i).getPrice()) +"\n";
        }
        return item;
    }

    public ArrayList<cart_products_model> getListCart() {
        return tinyDB.getListObject("CartList");
    }

}
