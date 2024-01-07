package com.AhlamAltofula.ahlam_altofula_project.Models;

public class boy_products_model {
        String title;
        int price;
        int pic;
        String dis;
        public boy_products_model(String title, int price, int pic , String dis) {
            this.title = title;
            this.price = price;
            this.pic = pic;
            this.dis = dis;
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

        public String getDis() {
            return dis;
        }
}
