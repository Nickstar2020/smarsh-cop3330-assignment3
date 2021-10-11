/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Nicholas Smarsh
 */

package ex45;

import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;

public class App {

    //reads input file and returns string array
    public static ArrayList<String> readFile() throws FileNotFoundException {
        File input = new File("src/main/java/ex45/exercise45_input.txt");
        ArrayList<String> list = new ArrayList<>();
        Scanner scan = new Scanner(input);

        try {
            while(scan.hasNext() ) {
                //loop that reads each word
                String filePath = scan.nextLine();
                list.add(filePath);
            }
        }
        finally {
            scan.close();
        }
        //send the list to main
        return list;
    }

    //writes into the output file
    public static int writeFile(ArrayList<String> list) throws IOException {
        FileWriter output = new FileWriter("src/main/java/ex45/exercise45_output.txt");
        int countModifications = 0;
        int index = 0;

        //loop entire list
        for(int i=0;i < list.size(); i++) {

            //temp string that allows comparison
            String temp = list.get(i);

            String changeWord = "utilize";
            index = 0;

            //counts the modifications
            while (true)
            {
                index = temp.indexOf(changeWord, index);
                if (index != -1) {
                    countModifications ++;
                    index += changeWord.length();
                }
                else {
                    break;
                }
            }

            //changes the word utilize to use
            temp = temp.replaceAll("utilize", "use");

            //then writes the modification to the output file
            output.write(temp + "\n");
        }

        //close the output when finished
        output.close();

        //return the number of modifications
        return countModifications;
    }

    public static void main(String[] args) throws IOException {
        //send the list to main
        ArrayList<String> list = readFile();
        //gather the number of mods using the output func
        int mods = writeFile(list);
        //print out the number of mods to console
        System.out.println("The number of modifications were " + mods);
    }
}
