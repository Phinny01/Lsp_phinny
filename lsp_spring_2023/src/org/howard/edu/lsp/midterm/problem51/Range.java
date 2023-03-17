package org.howard.edu.lsp.midterm.problem51;

public interface Range {
    boolean contains(int value);
    boolean overlaps(Range other) throws NullPointerException, Exception;
    int size();
}