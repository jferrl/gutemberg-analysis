package org.gutemberg.strategies;

import java.io.*;
import org.gutemberg.repository.Repository;

/**
 * ParagraphSize
 */
public class ParagraphSize extends Analysis {

    private double averageWords;

    public ParagraphSize(Repository repository) {
        super(repository);
        this.averageWords = 0;
    }

    @Override
    public void execute() {
        try {
            this.averageWords = 0;
            for (final File file : this.repository.getAllFiles()) {
                this.averageWords += this.getParagraphSize(file);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void getResult() {
        System.out.println("Words/paragraph average: " + this.averageWords);
    }

    private double getParagraphSize(File file) throws IOException {
        FileInputStream fileStream = new FileInputStream(file);
        int pl = 0;
        byte[] byteArray = new byte[(int) file.length()];
        fileStream.read(byteArray);
        String data = new String(byteArray);
        data = data.trim().replaceAll("(?m)(^ *| +(?= |$))", "").replaceAll("(?m)^$([\r\n]+?)(^$[\r\n]+?^)+", "$1");
        String[] paragraphs = data.toString().split("\r\n\r\n");
        pl = pl + paragraphs.length;
        fileStream.close();

        String[] words = null;
        int wc = 0;
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String s;
        while ((s = br.readLine()) != null) {
            words = s.split(" ");
            wc = wc + words.length;
        }
        br.close();

        double averageWords = (double) wc / (double) pl;
        return averageWords;
    }
}
