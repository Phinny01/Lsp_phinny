package org.howard.edu.hw5;
import java.util.ArrayList;
import java.util.List;

public class IntegerSet {
    // internal representation of the set using an ArrayList
    private List<Integer> set;

    public IntegerSet() {
        set = new ArrayList<Integer>();
    }

    /**
     * Clears the internal representation of the set.
     */
    public void clear() {
        set.clear();
    }

    /**
     * Returns the length of the set.
     * @return the length of the set as an integer.
     */
    public int length() {
        return set.size();
    }

    /**
     * Determines whether this IntegerSet is equal to the given IntegerSet.
     * @param b the IntegerSet to compare against.
     * @return true if the two sets are equal, false otherwise.
     * Two sets are equal if they contain all of the same values in ANY order.
     */
    public boolean equals(IntegerSet b) {
        // if the sizes of the sets are different, they are not equal
        if (set.size() != b.length()) {
            return false;
        }
        // check if every element in set a is in set b
        for (int element : set) {
            if (!b.contains(element)) {
                return false;
            }
        }
        // check if every element in set b is in set a
        for (int element : b.set) {
            if (!contains(element)) {
                return false;
            }
        }
        // if all elements match, the sets are equal
        return true;
    }

    /**
     * Determines whether this IntegerSet contains the given value.
     * @param value the value to check for.
     * @return true if the set contains the value, false otherwise.
     */
    public boolean contains(int value) {
        return set.contains(value);
    }

    /**
     * Returns the largest item in the set.
     * @return the largest item in the set as an integer.
     * @throws IntegerSetException if the set is empty.
     */
    public int largest() throws IntegerSetException {
        if (set.isEmpty()) {
            throw new IntegerSetException("Set is empty");
        }
        int largest = set.get(0);
        for (int element : set) {
            if (element > largest) {
                largest = element;
            }
        }
        return largest;
    }

    /**
     * Returns the smallest item in the set.
     * @return the smallest item in the set as an integer.
     * @throws IntegerSetException if the set is empty.
     */
    public int smallest() throws IntegerSetException {
        if (set.isEmpty()) {
            throw new IntegerSetException("Set is empty");
        }
        int smallest = set.get(0);
        for (int element : set) {
            if (element < smallest) {
                smallest = element;
            }
        }
        return smallest;
    }

    /**
     * Adds an item to the set if it is not already present.
     * @param item the item to add.
     */
    public void add(int item) {
        if (!set.contains(item)) {
            set.add(item);
        }
    }

    /**
     * Removes an item from the set if it is present.
     * @param item the item to remove.
     */
    public void remove(int item) {
        set.remove(Integer.valueOf(item));
    }

    /**
     * Adds all elements from the given IntegerSet to this IntegerSet. If an element
     * already exists in this IntegerSet, it will not be added again.
     * 
     * @param intSetb The IntegerSet to union with this IntegerSet
     */
    public void union(IntegerSet intSetb) {
        for (int element : intSetb.set) {
            add(element);
        }
    }

    /**
     * Removes all elements from this IntegerSet that are not in the given IntegerSet.
     * 
     * @param intSetb The IntegerSet to intersect with this IntegerSet
     */
    public void intersect(IntegerSet intSetb) {
        List<Integer> intersection = new ArrayList<Integer>();
        for (int element : set) {
            if (intSetb.contains(element)) {
                intersection.add(element);
            }
        }
        set = intersection;
    }

    /**
     * Removes all elements from this IntegerSet that are also in the given IntegerSet.
     * 
     * @param intSetb The IntegerSet to subtract from this IntegerSet
     */
    public void diff(IntegerSet intSetb) {
        for (int element : intSetb.set) {
            remove(element);
        }
    }

    /**
     * Returns a string representation of this IntegerSet.
     * 
     * @return A string representation of this IntegerSet.
     */
    public String toString() {
        if (set.isEmpty()) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < set.size() - 1; i++) {
            sb.append(set.get(i));
            sb.append(", ");
        }
        sb.append(set.get(set.size() - 1));
        sb.append("]");

        return sb.toString();
    }

    /**
     * Returns true if this IntegerSet is empty, false otherwise.
     * 
     * @return True if this IntegerSet is empty, false otherwise.
     */
    public boolean isEmpty() {
		// TODO Auto-generated method stub
		return set.isEmpty();
	}


}