package org.gutemberg.strategies;

import java.io.*;
import org.gutemberg.repository.Repository;

/**
 * Tokenization
 */
public class Tokenization extends Analysis {

    private FileOutputStream tokens;

    private final String outputFile;

    public Tokenization(Repository repository, String outputPath) {
        super(repository);
        this.outputFile = outputPath;
    }

    @Override
    public void execute() {
        try {
            this.tokens = new FileOutputStream(this.outputFile);
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
