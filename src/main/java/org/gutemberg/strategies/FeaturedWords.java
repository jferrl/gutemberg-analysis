package org.gutemberg.strategies;

import java.io.*;
import org.gutemberg.repository.Repository;

/**
 * Tokenization
 */
public class FeaturedWords extends Analysis {

    public FeaturedWords(Repository repository) {
        super(repository);
    }

    @Override
    public void execute() {
        try {
            for (final File file : this.repository.getAllFiles()) {
                this.readTokensFromFile(file);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    private void readTokensFromFile(File file) {
        try {
            StreamTokenizer tokenizer = new StreamTokenizer(new FileReader(file));
            System.out.println("File:" + file.getName() + "\n");
            while (tokenizer.nextToken() != StreamTokenizer.TT_EOF) {
                switch (tokenizer.ttype) {
                case StreamTokenizer.TT_NUMBER:
                    // System.out.println(new Double(tokenizer.nval).intValue());
                    break;
                case StreamTokenizer.TT_WORD:
                    // System.out.println(tokenizer.sval);
                    break;
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
