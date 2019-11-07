package org.gutemberg;

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
        GutembergRepository repository = new GutembergRepository("C:\\Git\\gutemberg-analysis\\dataset\\txt");

        // Case 1
        Tokenization tokenization = new Tokenization(repository);
        tokenization.execute();
        // Case 2
        FeaturedWords featuredWords = new FeaturedWords(repository);
        featuredWords.execute();
        featuredWords.getResult();
        // Case 3
        WordsCount wordsCount = new WordsCount(repository);
        wordsCount.execute();
        wordsCount.getResult();
        // Case 4
        NumbersCount numbersCount = new NumbersCount(repository);
        numbersCount.execute();
        numbersCount.getResult();
        // Case 5
    }
}
