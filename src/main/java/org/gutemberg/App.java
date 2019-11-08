package org.gutemberg;

import java.util.Scanner;

import org.gutemberg.repository.GutembergRepository;
import org.gutemberg.strategies.FeaturedWords;
import org.gutemberg.strategies.Tokenization;
import org.gutemberg.strategies.WordsCount;
import org.gutemberg.strategies.NumbersCount;

public final class App {
    /**
     * Start program execution
     * 
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        App.printMenu();

        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        sc.close();

        GutembergRepository repository = new GutembergRepository("C:\\Git\\gutemberg-analysis\\dataset\\txt");
        switch (option) {
        case 1:
            Tokenization tokenization = new Tokenization(repository);
            tokenization.execute();
            break;
        case 2:
            FeaturedWords featuredWords = new FeaturedWords(repository);
            featuredWords.execute();
            featuredWords.getResult();
            break;
        case 3:
            WordsCount wordsCount = new WordsCount(repository);
            wordsCount.execute();
            wordsCount.getResult();
            break;
        case 4:
            NumbersCount numbersCount = new NumbersCount(repository);
            numbersCount.execute();
            numbersCount.getResult();
            break;
        case 5:
            break;
        }
    }

    private static void printMenu() {
        System.out.println("Gutenberg Dataset. Enter a number between 1 and 5 for:\n"
                + "   -1: Tokenize the dataset in different sentences \n" + "   -2: Find the 10 most used words \n"
                + "   -3: Total number of words \n" + "   -4: Find number of number words \n"
                + "   -5: Average size of paragraph \n");
    }
}
