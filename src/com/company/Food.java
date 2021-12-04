package com.company;

public class Food {
    String name;
    String foodType;
    double foodPrice;

    public Food(String name, String foodType, double foodPrice) {

        this.name = name;
        this.foodType = foodType;
        this.foodPrice = foodPrice;
    }

    @Override
    public String toString() {
        return name + ", " + foodType + ", " + foodPrice;
    }

}
