package org.howard.edu.hw4;

public class Driver {
    public static void main(String[] args) {
        // create a new IntegerSet
        IntegerSet set = new IntegerSet();

        // add some elements to the set
        set.add(1);
        set.add(2);
        set.add(3);

        // print the set
        System.out.println("Set: " + set.toString());

        // test length() method
        System.out.println("Length of set: " + set.length());

        // test contains() method
        System.out.println("Set contains 2: " + set.contains(2));
        System.out.println("Set contains 4: " + set.contains(4));

        // test largest() method
        try {
            System.out.println("Largest element in set: " + set.largest());
        } catch (IntegerSetException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // test smallest() method
        try {
            System.out.println("Smallest element in set: " + set.smallest());
        } catch (IntegerSetException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // create a new set to test union() and intersect() methods
        IntegerSet set2 = new IntegerSet();
        set2.add(3);
        set2.add(4);
        set2.add(5);

        // test union() method
        set.union(set2);
        System.out.println("Union of set and set2: " + set.toString());

        // test intersect() method
        set.intersect(set2);
        System.out.println("Intersection of set and set2: " + set.toString());

        // test diff() method
        set.diff(set2);
        System.out.println("Difference of set and set2: " + set.toString());

        // test clear() method
        set.clear();
        System.out.println("Set after clear(): " + set.toString());

        // test isEmpty() method
        System.out.println("Set is empty: " + set.isEmpty());
    }
}
