package org.gutemberg.strategies;

import java.io.*;
import org.gutemberg.repository.Repository;

/**
 * NumbersCount
 */
public class NumbersCount extends Analysis {

    private int validYears;

    public NumbersCount(Repository repository) {
        super(repository);
        this.validYears = 0;
    }

    @Override
    public void execute() {
        this.validYears = 0;
        try {
            for (final File file : this.repository.getAllFiles()) {
                this.readTokensFromFile(file);
            }
            System.out.println();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void getResult() {
        System.out.println("Valid Years Count: " + this.validYears + "\n");
    }

    private void readTokensFromFile(File file) {
        try {
            StreamTokenizer tokenizer = new StreamTokenizer(new FileReader(file));
            while (tokenizer.nextToken() != StreamTokenizer.TT_EOF) {
                if (tokenizer.ttype == StreamTokenizer.TT_NUMBER) {
                    this.validYears += 1;
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
