package org.gutemberg.strategies;

import java.io.*;
import java.text.BreakIterator;

import org.gutemberg.repository.Repository;

/**
 * WordsCount
 */
public class WordsCount extends Analysis {

    private int countedWords;

    public WordsCount(Repository repository) {
        super(repository);
        this.countedWords = 0;
    }

    @Override
    public void execute() {
        try {
            this.countedWords = 0;
            for (final File file : this.repository.getAllFiles()) {
                this.countedWords += this.getWordsCountFromFile(file);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public int getResult() {
        return this.countedWords;
    }

    private int getWordsCountFromFile(File file) {
        try {
            String line;
            int countWords = 0;

            FileInputStream fileStream = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fileStream));

            while ((line = reader.readLine()) != null) {
                BreakIterator iterator = BreakIterator.getWordInstance();
                iterator.setText(line);
                while (iterator.next() != BreakIterator.DONE) {
                    countWords += 1;
                }
            }
            reader.close();
            // System.out.print("\nFile readed: " + file.getName() + ". Words: " +
            // Integer.toString(countWords) + "\n");
            return countWords;
        } catch (Exception e) {
            // TODO: handle exception
            return 0;
        }
    }
}
