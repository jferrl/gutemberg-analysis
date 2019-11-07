package org.gutemberg.strategies;

import java.io.*;
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
                if (!line.equals("")) {
                    String[] lineWords = line.split("\\s+");
                    countWords += lineWords.length;
                }
            }
            reader.close();
            System.out.print("\nFile readed: " + file.getName() + ". Words: " + Integer.toString(countWords) + "\n");
            return countWords;
        } catch (Exception e) {
            // TODO: handle exception
            return 0;
        }
    }
}