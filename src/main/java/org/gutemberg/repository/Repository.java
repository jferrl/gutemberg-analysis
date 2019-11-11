package org.gutemberg.repository;

import java.io.File;

/**
 * Repository
 */
public interface Repository {
    File[] getAllFiles();

    int size();
}
