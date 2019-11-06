package main.java.repository;

import java.io.File;

public interface Repository {
    public File[] getAllFiles();
    public int size();
}