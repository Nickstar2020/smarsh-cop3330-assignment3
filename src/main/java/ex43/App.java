/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Nicholas Smarsh
 */

package ex43;

import java.io.*;
import java.util.Scanner;

public class App {

    public static void createFramework(String author, String siteName, char javascript, char css) {
        //create path
        String currentPath = System.getProperty("user.dir") + "\\src\\main\\java\\ex43\\" + siteName;
        File input = new File(currentPath);

        //determine whether website was created or not
        boolean websiteCreated = input.mkdir();
        if(websiteCreated)
        {
            System.out.println("Created " + currentPath);
            try
            {
                //create framework of website folders
                FileWriter frameworkMaker = new FileWriter(currentPath +"\\index.html");
                frameworkMaker.write("<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n");
                frameworkMaker.write("\t<meta author=\""+author+"\">\n");
                frameworkMaker.write("\t<title>"+siteName+"</title>\n");
                frameworkMaker.write("</head>\n<body>\n\n</body>\n</html>");

                //close when finished writing
                frameworkMaker.close();

                //now make js or css folders if it was asked
                System.out.println("Created " + currentPath +"\\index.html");

                //if js was made
                if(javascript == 'Y' || javascript == 'y')
                {
                    //add path to js
                    File jsFolder = new File(currentPath + "\\javascript");
                    boolean jsCreated = jsFolder.mkdir();
                    if(jsCreated)
                    {
                        System.out.println("Created " + jsFolder);
                    }
                    else
                    {
                        //dont make one if it doesnt asks for it
                        System.out.println("Javascript folder was not made");
                    }
                }

                //if css is made
                if(css == 'Y' || css == 'y')
                {
                    //add path for css folder
                    File cssFolder = new File(currentPath +"\\css");
                    boolean cssCreated = cssFolder.mkdir();
                    if(cssCreated)
                    {
                        System.out.println("Created " + cssFolder);
                    }
                    else
                    {
                        //dont make one if it doesnt asks for it
                        System.out.println("CSS folder was not made");
                    }
                }
            }
            catch(IOException e)
            {
                System.out.println("index.html not made");
            }
        }
        //if the folder couldn't be made
        else
        {
            System.out.println("The website folder was not made :(");
        }
    }

    public static void main(String[] args) {

        //vars that are needed
        String author;
        String siteName;
        char javascript;
        char css;

        //create scanner that takes system input
        Scanner scan = new Scanner(System.in);

        //ask for site name
        System.out.print("Enter site name: ");
        siteName = scan.nextLine();

        //ask for creator
        System.out.print("Enter the creator: ");
        author = scan.nextLine();

        //ask if they want js folder
        System.out.print("Create folder for Java script? (y/n) : ");
        javascript = scan.next().charAt(0);

        //ask if they want css folder
        System.out.print("Create folder for CSS? (y/n) : ");
        css = scan.next().charAt(0);

        //function that creates the framework with the given information.
        createFramework(author, siteName, javascript, css);
    }
}