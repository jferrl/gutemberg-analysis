package org.gutemberg.strategies;
import java.io.*;
import org.gutemberg.repository.Repository;

import java.util.regex.Pattern;

/**
 * ParagraphSize
 */
public class ParagraphSize extends Analysis {

    private double avarageWords;

    public ParagraphSize(Repository repository) {
        super(repository);
        this.avarageWords = 0;
    }

    @Override
    public void execute() {
        try {
           
            this.avarageWords = 0;
            for (final File file : this.repository.getAllFiles()) {
                this.avarageWords +=this.getParagraphSize(file);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

    }
    

    public void getResult() {

        System.out.println("Media: " +this.avarageWords) ;

    }

    private double getParagraphSize(File file) throws IOException {


        FileInputStream fileStream = new FileInputStream(file);
        int pl=0;
        byte[] byteArray = new byte[(int)file.length()];
        fileStream.read(byteArray);
        String data = new String(byteArray);
        data=data.trim().replaceAll("(?m)(^ *| +(?= |$))", "").replaceAll("(?m)^$([\r\n]+?)(^$[\r\n]+?^)+", "$1");
        String[] paragraphs = data.toString().split("\r\n\r\n");
        pl=pl+paragraphs.length;




        String[] words=null;    //Intialize the word Array
        int wc=0;     //Intialize word count 2 zero
        FileReader fr = new FileReader(file);    //Creation of File Reader object
        BufferedReader br = new BufferedReader(fr);    //Creation of BufferedReader object
        String s;
        while((s=br.readLine())!=null)    //Reading Content from the file
        {
            words=s.split(" ");   //Split the word using space
            wc=wc+words.length;   //increase the word count for each word
        }





        double avarageWords = (double)wc/(double)pl;
        return  avarageWords;
    }







}


