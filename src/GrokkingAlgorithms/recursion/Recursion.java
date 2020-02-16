package GrokkingAlgorithms.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Recursion {
    public static void main(String[] args) {
        //Create test environment
        Box b1 = new Box(new ArrayList<Integer>(Arrays.asList(4, 5)), null);
        Box b2 = new Box(new ArrayList<Integer>(Arrays.asList(12, 22, 32, 42, 52)), Collections.singletonList(b1));
        Box b3 = new Box(new ArrayList<Integer>(Arrays.asList(13, 23, 33, 43, 53)), Collections.singletonList(b2));
        Box b4 = new Box(new ArrayList<Integer>(Arrays.asList(142, 34, 44, 54)), Collections.singletonList(b3));
        Box b5 = new Box(new ArrayList<Integer>(Arrays.asList(142, 34, 44, 54)), Collections.singletonList(b4));
        Box b6 = new Box(new ArrayList<Integer>(Arrays.asList(1425, 342, 442, 542)), Collections.singletonList(b5));
        Box b7 = new Box(new ArrayList<Integer>(Arrays.asList(1425, 343, 443, 543)), null);
        Box b8 = new Box(new ArrayList<Integer>(Arrays.asList(1425, 344, 444, 544)), Collections.singletonList(b7));
        Box b9 = new Box(new ArrayList<Integer>(Collections.singletonList(3)), null);
        Box b11 = new Box(new ArrayList<Integer>(Collections.singletonList(2)), Collections.singletonList(b9));
        Box mainBox = new Box(new ArrayList<Integer>(Collections.singletonList(1)), Arrays.asList(b11, b8, b6));

        System.out.println(checkBox(mainBox, 0));
        System.out.println(checkBox(mainBox, 44));
        System.out.println(checkBox(mainBox, 2));
        System.out.println(checkBox(mainBox, 2345123));
        System.out.println(checkBox(mainBox, -46785));
    }

    private static boolean checkBox(Box box, int toCheck) {
        if (BoxManager.containsIntegers(box)) {
            if (BoxManager.containsInteger(box.getIntegers(), toCheck)) return true;
        }
        if (BoxManager.containsBoxes(box)) {
            for (Box innerBox : box.getBoxes()) {
                if (checkBox(innerBox, toCheck)) return true;
            }
        }
        return false;
    }
}
