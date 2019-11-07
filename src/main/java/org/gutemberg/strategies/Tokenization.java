package org.gutemberg.strategies;

import java.io.*;
import org.gutemberg.repository.Repository;

/**
 * Tokenization
 */
public class Tokenization extends Analysis {

    private FileOutputStream tokens;

    public Tokenization(Repository repository) {
        super(repository);
    }

    @Override
    public void execute() {
        try {
            this.tokens = new FileOutputStream("C:\\Git\\tokens.txt");
            for (final File file : this.repository.getAllFiles()) {
                this.readTokensFromFile(file);
            }
            this.tokens.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    private void readTokensFromFile(File file) {
        try {
            StreamTokenizer tokenizer = new StreamTokenizer(new FileReader(file));
            while (tokenizer.nextToken() != StreamTokenizer.TT_EOF) {
                if (tokenizer.ttype == StreamTokenizer.TT_WORD) {
                    this.writeTokenToFile(tokenizer.sval + ",");
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    private void writeTokenToFile(String token) {
        try {
            byte byteToken[] = token.getBytes();
            this.tokens.write(byteToken);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
