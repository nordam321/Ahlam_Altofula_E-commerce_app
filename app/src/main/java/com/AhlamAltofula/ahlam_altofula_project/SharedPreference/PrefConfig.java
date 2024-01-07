package com.AhlamAltofula.ahlam_altofula_project.SharedPreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.AhlamAltofula.ahlam_altofula_project.Models.cart_products_model;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class PrefConfig {

    private static final String LIST_KEY = "list_key";

    public static void writeListInPref(Context context , ArrayList<cart_products_model> list){
        Gson gson = new Gson();
        String jsonString = gson.toJson(list);
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(LIST_KEY , jsonString);
        editor.apply();
    }

    public static List<cart_products_model> readListFromPref(Context context){
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        String jsonString = pref.getString(LIST_KEY,"");
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<cart_products_model>>(){}.getType();
        ArrayList<cart_products_model> list = gson.fromJson(jsonString,type);
        return list;

    }

}
