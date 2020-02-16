package GrokkingAlgorithms.recursion;

import java.util.List;

public class BoxManager {

    public static boolean containsIntegers(Box box) {
        return box.getIntegers() != null && !box.getIntegers().isEmpty();
    }

    public static boolean containsBoxes(Box box) {
        return box.getBoxes() != null && !box.getBoxes().isEmpty();
    }

    public static boolean containsInteger(List<Integer> integers, int toCheck) {
        for (int i : integers) {
            if (i == toCheck)
                return true;
        }
        return false;
    }
}
