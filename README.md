# Gutemberg Analysis

[![Maintainability](https://api.codeclimate.com/v1/badges/3dcbeed599bb53561265/maintainability)](https://codeclimate.com/github/jferrl/gutemberg-analysis/maintainability)

This project has been created with the purpose of analyzing the linguistic corpus of Gutemberg. In addition, this java project will be prepared to adapt it to a Hadoop execution.

## Gutenberg Dataset

This is a collection of 3,036 English books written by 142 authors. This collection is a small subset of the Project Gutenberg corpus. All books have been manually cleaned to remove metadata, license information, and transcribers' notes, as much as possible.

Link to dataset: https://drive.google.com/file/d/0B2Mzhc7popBga2RkcWZNcjlRTGM/edit

## Tests performed

-   Tokenize the dataset in different sentences
-   Find the 10 most used words
-   Total number of words
-   Find valid numeric words
-   Average size of paragraph

## Team Members

Luis Gómez García
Cansu Ozturk
Jorge Ferrero Linacero

## How to execute it

From vscode:

-   Run
-   Debug

Program accepts gutemberg file location as execution args(args[0] = Path of gutemberg dataset)
