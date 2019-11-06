package main.java.repository;

import java.io.File;

/**
 * GutembergRepository
 */
public class GutembergRepository implements Repository {

    private File folder;

    public GutembergRepository(String folder) {
        this.folder = new File(folder);
    }

    public void getAll() {
        for (final File fileEntry : folder.listFiles()) {
            if (!fileEntry.isDirectory()) {
                System.out.println(fileEntry.getName());
            } 
        }
    }
}