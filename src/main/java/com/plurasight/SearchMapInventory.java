package com.plurasight;

import java.util.regex.Pattern;

public class SearchMapInventory {
    long vehicleId;
    String makeModel;
    double price;

    SearchMapInventory(String  vehicle){

        //get the car info and spilt them by | so each part go to the right type by converting them
        String[] vechicles = vehicle.split(Pattern.quote("|"));

        //orgnize each value where should it go
        this.vehicleId = Long.parseLong(vechicles[0]);
        this.makeModel = vechicles[1];
        this.price = Double.parseDouble(vechicles[2]);
    }

    //Display the products
    public void display(){

        System.out.printf("ID:%d, Model:%s, Price:%f.2\n", this.vehicleId, this.makeModel, this.price);
    }

    public String toString() {
        return vehicleId + " | " + makeModel + " | " + price;
    }



}