package main.java.repository;

import java.io.File;

public interface Repository {
    public File[] getAll();
    public int size();
}