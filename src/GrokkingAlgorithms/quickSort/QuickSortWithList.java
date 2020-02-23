package GrokkingAlgorithms.quickSort;

import util.ConsolePrinter;
import util.DataCreator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class QuickSortWithList {
    public static void main(String[] args) {
        int[] arr = DataCreator.getUnsortedIntegerArray(100, true);
        ConsolePrinter.printIntArray(arr, false, false);
        List<Integer> list = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.toList());

        list = sort(list);
        for (int i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static List<Integer> sort(List<Integer> list) {
        if (list.size() < 2) {
            return list;
        }
        int base = list.get(0).intValue();
        List<Integer> smaller = new ArrayList<>();
        List<Integer> bigger = new ArrayList<>();
        //check all elements with base and place it in bigger or smaller
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).intValue() >= base) {
                bigger.add(list.get(i));
            } else {
                smaller.add(list.get(i));
            }
        }
        bigger = sort(bigger);
        smaller = sort(smaller);
        smaller.add(Integer.valueOf(base));
        smaller.addAll(bigger);
        return smaller;
    }
}
