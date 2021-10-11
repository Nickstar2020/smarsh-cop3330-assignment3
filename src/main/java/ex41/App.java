/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Nicholas Smarsh
 */

package ex41;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.Collections;
import java.io.IOException;
import java.util.ArrayList;

public class App {
    //function that outputs the names onto the output file
    public static void outputNames(ArrayList<String> listOfNames) throws IOException {
        //find the file
        File output = new File("src/main/java/ex41/exercise41_output.txt");
        FileWriter outputFile = new FileWriter(output);

        //output the header for the output file
        outputFile.write("Total of " + listOfNames.size() + " names:\n");
        outputFile.write("__________________\n");

        //for loop that loops through the arraylist and writes out the name onto the output file
        for (String name : listOfNames) {
            outputFile.write( name + "\n");
        }

        //close file when done
        outputFile.close();
    }

    //function that reads the input file and copies info into a string array list
    public static void readNames(Scanner input, ArrayList<String> listOfNames) {
        //loop through the input inside the txt
        //hasNextLine ensures that there is text in the next line

        while (input.hasNextLine()) {
            //add name to list
            listOfNames.add(input.nextLine());
        }

        //close input
        input.close();
    }

    public static void main(String[] args) throws IOException {
        //read input file
        File input = new File("src/main/java/ex41/exercise41_input.txt");
        Scanner inputFile = new Scanner(input);

        //create array list in order to send to readNames func
        ArrayList<String> listOfNames = new ArrayList<>();

        //send array list to readNames and also input file
        readNames(inputFile, listOfNames);

        //now that the listOfNames has names in it, we use the java String sort to alphabetize the names
        Collections.sort(listOfNames, String.CASE_INSENSITIVE_ORDER);

        //send listOfNames (now sorted) to output func which will print the names onto the output txt
        outputNames(listOfNames);
    }
}