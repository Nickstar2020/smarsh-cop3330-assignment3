/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Nicholas Smarsh
 */

package ex42;

import java.io.*;
import java.util.*;

class App {
    //print method that takes file and prints out info in described format
    public static void printEmployee(File info) throws FileNotFoundException {
        //create scanner for input
        Scanner inputInfo = new Scanner(info);
        //create header
        //easier way to do the spacing (like c)
        System.out.printf("%-20s%-20s%-20s\n", "last", "first", "salary");
        System.out.println("_____________________________________________");

        //loop through the information and
        while (inputInfo.hasNext()) {
            String name = inputInfo.nextLine();
            String[] information = name.split(",");
            System.out.printf("%-20s%-20s%-20s\n", information[0], information[1], information[2]);
        }

        //close file once done
        inputInfo.close();
    }

    //main gives file to printEmployee method
    public static void main(String[] args) throws FileNotFoundException {
        //take in input
        File input = new File("src/main/java/ex42/exercise42_input.txt");
        //give file to method
        printEmployee(input);
    }
}
