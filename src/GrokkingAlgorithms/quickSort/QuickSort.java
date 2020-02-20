package GrokkingAlgorithms.quickSort;

import util.DataCreator;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class QuickSort {
    public static void main(String[] args) {
        int[] g = DataCreator.getUnsortedIntegerArray(100000, true);
        List<Integer> list = Arrays.stream(g)
                .boxed()
                .collect(Collectors.toList());

        for (int i : list) {
            System.out.print(i + " ");
        }
        list = sort(list);
        System.out.println();

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
        int biggerIndex=0, smallerIndex=0;
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

//    private static int[] combine(int[] smaller, int base, int[] bigger) {
//        int[] combinedArr = new int[smaller.length + 1 + bigger.length];
//        System.arraycopy(smaller, 0, combinedArr, 0, smaller.length);
//        combinedArr[smaller.length] = base;
//        System.arraycopy(bigger, 0, combinedArr, smaller.length + 1, bigger.length);
//        return combinedArr;
//    }
}
