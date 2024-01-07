package com.AhlamAltofula.ahlam_altofula_project.Models;

public class girl_products_model {
    String title;
    int price;
    int pic;
    public girl_products_model(String title, int price, int pic) {
        this.title = title;
        this.price = price;
        this.pic = pic;
    }
    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    public int getPic() {
        return pic;
    }


}
