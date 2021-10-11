/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Nicholas Smarsh
 */

package ex46;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class App {

    //read all the words
    public static ArrayList<String> readFile() throws FileNotFoundException {
        File inputFile = new File("src/main/java/ex46/exercise46_input.txt");
        ArrayList<String> allWords = new ArrayList<>();

        try (Scanner scan = new Scanner(inputFile)) {
            while (scan.hasNext()) {
                String filePath = scan.next();
                allWords.add(filePath);
            }
        }

        //send all words from array list
        return allWords;
    }

    static int countOccurrences(ArrayList<String> allWords, String word)
    {
        // search for pattern in
        int count = 0;
        for (int i = 0; i < allWords.size(); i++)
        {
            // if match found increase count
            if (word.equals(allWords.get(i)))
                count++;
        }

        return count;
    }

    //take in 2 arrays and print out the array that is the largest in terms of occurrences
    public static void findHighestOccurrence(int[] count, String[] word, int wordAmount){
        String tempStr;
        int tempNum;

        //look at count
        for(int n=0; n < wordAmount; n++) {
            for(int i=0; i< wordAmount; i++) {
                if(count[i] < count[i+1]) {
                    //create temps and swap
                    tempNum = count[i];
                    tempStr = word[i];

                    count[i] = count[i+1];
                    word[i] = word[i+1];

                    count[i+1] = tempNum;
                    word[i+1] = tempStr;
                }
            }
        }

        //generate visuals for each word size
        String[] graphVisual = new String[wordAmount];

        for(int n=0; n < wordAmount;n++) {
                graphVisual[n] = "";
            for(int i=0; i<count[n]; i++) {
                //add a "*" to specific string for how many times it's been counted
                graphVisual[n] += "*";
            }
        }

        //print out the word and how many times it's been counted
        for(int i=0; i< wordAmount; i++) {
            System.out.println(word[i] + ":" + graphVisual[i]);
        }

    }

    //look through all the words and pair the occurrences together then print them out in order
    public static void findTheWords(ArrayList<String> allWords) throws IOException {
        int[] count = new int[allWords.size()];
        String[] word = new String[allWords.size()];
        boolean wordIsThere = false;
        int tempNumb = 0;

        //look through every word
        for(int i=0; i< allWords.size(); i++) {
            //set temp word to compare
            String temp = allWords.get(i);

            //loop through word list to see if word is already in array
            for(int j=0; j<word.length; j++) {
                if(Objects.equals(temp, word[j])) {
                    wordIsThere = true;
                }
            }
            //checks if word is there
            if(!wordIsThere) {
                word[tempNumb] = temp;
                count[tempNumb] = countOccurrences(allWords, word[tempNumb]);
                tempNumb++;
            }
            //set word is there back to false
            wordIsThere = false;
        }

        //call function to sort arrays
        findHighestOccurrence(count, word, tempNumb);

    }



    public static void main(String[] args) throws IOException {
        //make array and send it to the function that finds the words and how many times it's been called
        ArrayList<String> allWords = readFile();
        findTheWords(allWords);
    }
}