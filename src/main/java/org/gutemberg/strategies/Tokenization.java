package org.gutemberg.strategies;

import java.io.*;
import java.text.BreakIterator;

import org.gutemberg.repository.Repository;

/**
 * Tokenization
 */
public class Tokenization extends Analysis {

    public Tokenization(Repository repository) {
        super(repository);
    }

    @Override
    public void execute() {
        try {
            for (final File file : this.repository.getAllFiles()) {
                getSentencesFromFile(file);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    private void getSentencesFromFile(File file) {
        try {
            String line;

            FileInputStream fileStream = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fileStream));

            while ((line = reader.readLine()) != null) {
                BreakIterator iterator = BreakIterator.getWordInstance();
                iterator.setText(line);
                while (iterator.next() != BreakIterator.DONE) {

                }
            }
            reader.close();

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
