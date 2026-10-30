package com.plurasight;

import java.io.*;
import java.util.HashMap;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        //Declear a HashMap to store the details in it
        HashMap<String, SearchMapInventory>  inventory = new HashMap<>();

        inventory = loadInventory();

        for (SearchMapInventory productClass : inventory.values()){
            System.out.println(productClass);
        }

    }



    //this hash method it store a product in hashMap and return that hashmap
    public static HashMap<String,SearchMapInventory> loadInventory(){
        SearchMapInventory productClass;
        HashMap<String,SearchMapInventory> products = new HashMap<>();

        try {
            FileReader file = new FileReader("src/main/resources/inventory.csv");
            BufferedReader bufreader = new BufferedReader(file);
            //while run till stop's value change to false
            boolean stop = true;
            do{
                String product = bufreader.readLine();
                if (product == null){
                    stop = false;
                    bufreader.close();
                    break;
                }
                productClass = new SearchMapInventory(product);
                //take the id from the product so we can store it in a hashMap pairs key = id and value = product
                String[] productId = product.split("\\|");
                //Storing the product that pass to this method in a class by passing the info to the constructor initlazation.
                products.put(productId[0],productClass);
            }while (stop);
        } catch (Exception e) {
            System.out.println(e);
        }

        //return the hashMap of the product
        return products;
    }
}
