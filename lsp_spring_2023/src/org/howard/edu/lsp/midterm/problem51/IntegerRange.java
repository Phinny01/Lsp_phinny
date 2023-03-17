package org.howard.edu.lsp.midterm.problem51;

import java.util.Objects;

public class IntegerRange implements Range {
    private int lower;
    private int upper;

    public IntegerRange(int lower, int upper) {
        if (lower > upper) {
            throw new IllegalArgumentException("Lower bound cannot be greater than upper bound");
        }
        this.lower = lower;
        this.upper = upper;
    }

    public int getLower() {
        return lower;
    }

    public int getUpper() {
        return upper;
    }

    public boolean contains(int value) {
        return value >= lower && value <= upper;
    }

    public boolean overlaps(Range other) throws Exception {
        if (Objects.isNull(other)) {
            throw new IllegalArgumentException("Range object cannot be null.");
        }
        if (other instanceof IntegerRange) {
            IntegerRange otherRange = (IntegerRange) other;
            return !(upper < otherRange.getLower() || lower > otherRange.getUpper());
        } else {
            throw new IllegalArgumentException("Range must be an instance of IntegerRange");
        }
    }

    public int size() {
        return upper - lower + 1;
    }
}
