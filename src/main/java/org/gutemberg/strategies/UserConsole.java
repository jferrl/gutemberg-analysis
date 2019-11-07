package org.gutemberg.strategies;

import java.util.Scanner;

/**
 * UserConsole
 */
public class UserConsole {

 static   public void printMenu(){
        System.out.println("Gutenberg Dataset. Enter a number between 1 and 5 for:\n" +
        "   -1: Tokenize the dataset in different sentences \n"+
        "   -2: Find the 10 most used words \n"+
        "   -3: Total number of words \n"+
        "   -4: Find Valid year data \n"+
        "   -5: Average size of paragraph \n"
         );


    }
 static   public int consoleInt(){
        Scanner sc= new Scanner(System.in);


        int option=sc.nextInt();
       
        

        sc.close();
        return option;
        

    }
}