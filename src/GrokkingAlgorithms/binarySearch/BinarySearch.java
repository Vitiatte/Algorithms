package GrokkingAlgorithms.binarySearch;

import util.DataCreator;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = DataCreator.getSortedIntegerArray(1000000, false);
        System.out.println(getElementIndex(arr, 456734));
    }

    private static int getElementIndex(int[] arr, int element) {
        int start = 0, end = arr.length;
        while (start <= end) {
            int medium = (end + start) / 2;
            if (element == arr[medium]) {
                return medium;
            } else if (element < arr[medium]) {
                end = medium - 1;
            } else {
                start = medium + 1;
            }
        }
        return -1;
    }
}
