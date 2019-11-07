package org.gutemberg;

import org.gutemberg.repository.GutembergRepository;
import org.gutemberg.strategies.Tokenization;
import org.gutemberg.strategies.WordsCount;

public final class App {
    /**
     * Start program execution
     * 
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        GutembergRepository repository = new GutembergRepository("C:\\Git\\gutemberg-analysis\\dataset\\txt");

        // Case 1
        Tokenization tokenization = new Tokenization(repository, "C:\\Git\\tokens.txt");
        tokenization.execute();

        // Case 3
        WordsCount wordsCount = new WordsCount(repository);
        wordsCount.execute();
        System.out.println("Number of Words: " + wordsCount.getResult() + "\n");
    }
}
