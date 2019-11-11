package org.gutemberg.strategies;

import java.io.*;
import org.gutemberg.repository.Repository;

/**
 * ParagraphSize
 */
public class ParagraphSize extends Analysis {

    private int words;
    private int paragraphs;

    public ParagraphSize(Repository repository) {
        super(repository);
        this.words = 0;
        this.paragraphs = 0;
    }

    @Override
    public void execute() {
        try {
            this.words = 0;
            this.paragraphs = 0;
            for (final File file : this.repository.getAllFiles()) {
                this.getParagraphSize(file);
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void getResult() {
        System.out.println("Words/paragraph average: " + (double) this.words / (double) this.paragraphs);
    }

    private void getParagraphSize(File file) throws IOException {
        FileInputStream fileStream = new FileInputStream(file);
        byte[] byteArray = new byte[(int) file.length()];
        fileStream.read(byteArray);
        String data = new String(byteArray);
        data = data.trim().replaceAll("(?m)(^ *| +(?= |$))", "").replaceAll("(?m)^$([\r\n]+?)(^$[\r\n]+?^)+", "$1");
        String[] paragraphs = data.toString().split("\r\n\r\n");
        this.paragraphs += paragraphs.length;
        fileStream.close();

        String[] words = null;
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String s;
        while ((s = br.readLine()) != null) {
            words = s.split(" ");
            this.words += words.length;
        }
        br.close();
    }
}
