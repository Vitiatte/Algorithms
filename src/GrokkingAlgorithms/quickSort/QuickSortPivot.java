package GrokkingAlgorithms.quickSort;

import util.ConsolePrinter;
import util.DataCreator;

public class QuickSortPivot {
    public static void main(String[] args) {
        int[] arr = DataCreator.getUnsortedIntegerArray(30, true);
        ConsolePrinter.printIntArray(arr, false, true);

        sort(arr, 0, arr.length - 1);
        ConsolePrinter.printIntArray(arr, false, true);
    }

    /**
     * Sort integer array
     */
    private static void sort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);

            sort(arr, low, pivot - 1);
            sort(arr, pivot + 1, high);
        }
    }

    /**
     * Get first element arr[low] as a pivot. Next iterate over element from low + 1 to high
     * and put them in right position relative to the chosen pivot.
     * The last step is put the pivot in the right position.
     * <p>
     * Example:
     * Input params: arr = [3,2,6,2,8,1,9]; low = 0; high = 6
     * So, the array after performing this function will be look like: [2,3,1,3,8,6,9]
     * and function return 3 - index of pivot.
     *
     * @return return index of pivot
     */
    private static int partition(int[] arr, int low, int high) {
        int lastEqualOrLessThanPivot = low;
        for (int i = low + 1; i <= high; i++) {
            if (arr[i] < arr[low]) {
                lastEqualOrLessThanPivot++;

                int temp = arr[lastEqualOrLessThanPivot];
                arr[lastEqualOrLessThanPivot] = arr[i];
                arr[i] = temp;
            }
        }

        int temp = arr[low];
        arr[low] = arr[lastEqualOrLessThanPivot];
        arr[lastEqualOrLessThanPivot] = temp;

        return lastEqualOrLessThanPivot;
    }
}
