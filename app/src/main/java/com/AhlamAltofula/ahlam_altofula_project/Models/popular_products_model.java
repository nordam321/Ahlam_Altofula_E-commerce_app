package com.AhlamAltofula.ahlam_altofula_project.Models;

public class popular_products_model {
    private String title;
    private String description;
    private int price;
    private int images;

    public popular_products_model(String title, String description, int price ,int images) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.images = images;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public int getImages() {
        return images;
    }
}
