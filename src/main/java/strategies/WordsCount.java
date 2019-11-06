package main.java.strategies;

import java.io.*;
import main.java.repository.Repository; 

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
            for (final File file : this.repository.getAll()) {
                this.countedWords += this.readFile(file);
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    private int readFile(File file) {
        try {
            String line; 
            int countWords = 0; 

            FileInputStream fileStream = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fileStream)); 

            while((line = reader.readLine()) != null) {  
                if(!line.equals("")) {                   
                    String[] lineWords = line.split("\\s+"); 
                    countWords += lineWords.length;  
                } 
            }
            reader.close(); 
            return countWords;
        } catch (Exception e) {
            //TODO: handle exception
            return 0;
        }
    }

    public int getResult() {
        return this.countedWords;
    }
}