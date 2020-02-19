package GrokkingAlgorithms.quickSort;

import util.DataCreator;

import java.lang.reflect.Array;
import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] g = DataCreator.getUnsortedIntegerArray(20, false);
        int[] sortedArr = sort(g);

        for (int i : g) {
            System.out.print(i);
        }

        System.out.println();

        for (int i : sortedArr) {
            System.out.print(i);
        }
    }

    private static int[] sort(int[] arr) {
        if (arr.length < 2) {
            return arr;
        }
        int base = arr[0];
        int[] smaller =  new int[arr.length], bigger = new int[arr.length];
        //check all elements with base and place it in bigger or smaller
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] >= base) {
                bigger[bigger.length] = arr[i];
            } else {
                smaller[smaller.length] = arr[i];
            }
        }
        return combine(smaller, base, bigger);
    }

    private static int[] combine(int[] smaller, int base, int[] bigger) {
        int[] combinedArr = new int[smaller.length + 1 + bigger.length];
        System.arraycopy(smaller, 0, combinedArr, 0, smaller.length);
        combinedArr[smaller.length] = base;
        System.arraycopy(bigger, 0, combinedArr, smaller.length + 1, bigger.length);
        return combinedArr;
    }
}
