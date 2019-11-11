package org.gutemberg;

import java.util.Scanner;

import org.gutemberg.repository.GutembergRepository;
import org.gutemberg.strategies.FeaturedWords;
import org.gutemberg.strategies.Tokenization;
import org.gutemberg.strategies.WordsCount;
import org.gutemberg.strategies.NumbersCount;
import org.gutemberg.strategies.ParagraphSize;
import java.util.concurrent.TimeUnit;

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

        long startTime = System.currentTimeMillis();
        GutembergRepository repository = new GutembergRepository(App.getGutembergPath(args));
        App.executeAnalysis(option, repository);
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Elapsed time: " + TimeUnit.MILLISECONDS.toSeconds(elapsedTime) + " seconds");
    }

    private static void executeAnalysis(int option, GutembergRepository repository) {
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
            ParagraphSize paragraphSize = new ParagraphSize(repository);
            paragraphSize.execute();
            paragraphSize.getResult();
            break;
        }
    }

    private static String getGutembergPath(String[] args) {
        String path = args[0];
        if (path == null || path == "") {
            throw new Error("Invalid gutemberg path");
        }
        return path;
    }

    private static void printMenu() {
        System.out.println("Gutenberg Dataset. Enter a number between 1 and 5 for:\n"
                + "   -1: Tokenize the dataset in different words \n" + "   -2: Find the 10 most used words \n"
                + "   -3: Total number of words \n" + "   -4: Find number of number words \n"
                + "   -5: Average size of paragraph \n");
    }
}
