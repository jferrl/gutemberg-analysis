package org.gutemberg.strategies;

import org.gutemberg.repository.Repository;

/**
 * Analysis
 */
public abstract class Analysis implements AnalysisStrategy {

    protected final Repository repository;

    public Analysis(Repository repository) {
        this.repository = repository;
    }

    public abstract void execute();
}
