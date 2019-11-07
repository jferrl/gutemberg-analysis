package org.gutemberg;

import org.gutemberg.repository.GutembergRepository;
import org.gutemberg.strategies.FeaturedWords;
import org.gutemberg.strategies.Tokenization;
import org.gutemberg.strategies.UserConsole;
import org.gutemberg.strategies.WordsCount;
import org.gutemberg.strategies.NumbersCount;

public final class App {
    /**
     * Start program execution
     * 
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        GutembergRepository repository = new GutembergRepository("C:\\Git\\gutemberg-analysis\\dataset\\txt");

        UserConsole.printMenu();
        int option= UserConsole.consoleInt();
        switch(option){
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
}
