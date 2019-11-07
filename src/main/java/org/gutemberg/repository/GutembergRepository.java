package org.gutemberg.repository;

import java.io.File;

/**
 * GutembergRepository
 */
public class GutembergRepository implements Repository {

    private final File folder;

    public GutembergRepository(String folder) {
        this.folder = new File(folder);
    }

    @Override
    public File[] getAllFiles() {
        return this.folder.listFiles();
    }

    @Override
    public int size() {
        return this.folder.listFiles().length;
    }
}
