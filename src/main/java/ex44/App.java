/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Nicholas Smarsh
 */

package ex44;

import java.io.*;
import java.util.*;
import org.json.simple.parser.*;
import org.json.simple.*;

public class App {
    public static void printProduct(String input) {
        //create parser for data
        JSONParser parser = new JSONParser();
        //create boolean to see if object is there or not
        boolean isThere = false;

        //try reading the json file
        try {
            //create object that parses through input.json
            Object object = parser.parse(new FileReader("src/main/java/ex44/exercise44_input.json"));

            //make object from json
            JSONObject jsonObject = (JSONObject)object;

            //read in array of products
            JSONArray products = (JSONArray)jsonObject.get("products");

            //loop through if there is next line
            for (Object product : products) {
                //Create another json
                JSONObject json = (JSONObject) product;

                //Get the name value
                String name = (String) json.get("name");

                if (input.toLowerCase().equals(name.toLowerCase())) {
                    //print out the data of the product
                    System.out.println("name: " + name);
                    System.out.println("price: " + json.get("price"));
                    System.out.println("quantity: " + json.get("quantity"));
                    //set to true since it exist
                    isThere = true;
                }
            }
            if(!isThere) {
                System.out.println("Sorry, that product was not found in our inventory.");
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //ask for the name
        System.out.print("What is the product name? ");
        String input = scan.nextLine();

        //send input to func
        printProduct(input);
    }
}
