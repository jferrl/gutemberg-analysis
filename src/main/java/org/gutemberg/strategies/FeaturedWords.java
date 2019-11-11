package org.gutemberg.strategies;

import java.io.*;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.gutemberg.repository.Repository;

/**
 * FeaturedWords
 */
public class FeaturedWords extends Analysis {

    private HashMap<String, Integer> words;

    public FeaturedWords(Repository repository) {
        super(repository);
        this.words = new HashMap<String, Integer>();
    }

    @Override
    public void execute() {
        try {
            this.words.clear();
            for (final File file : this.repository.getAllFiles()) {
                this.readTokensFromFile(file);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void getResult() {
        System.out.println("Featured Words: " + this.words.toString() + "\n");
    }

    private void readTokensFromFile(File file) {
        try {
            StreamTokenizer tokenizer = new StreamTokenizer(new FileReader(file));
            while (tokenizer.nextToken() != StreamTokenizer.TT_EOF) {
                switch (tokenizer.ttype) {
                case StreamTokenizer.TT_NUMBER:
                    this.addWordToMap(Integer.toString((int) tokenizer.nval));
                    break;
                case StreamTokenizer.TT_WORD:
                    this.addWordToMap(tokenizer.sval.toLowerCase());
                    break;
                }
            }
            this.words = this.words.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .limit(10).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1,
                            LinkedHashMap::new));
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    private void addWordToMap(String word) {
        if (!this.words.containsKey(word)) {
            this.words.put(word, 1);
            return;
        }
        this.words.put(word, this.words.get(word) + 1);
    }
}
