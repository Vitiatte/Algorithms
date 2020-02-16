package util;

public class DataCreator {

    /**
     * Return sorted array with integers.
     * @param numberElements
     * @param consistentSet - if true, return consistent set of integers in array starts form 0
     */
    public static int[] getSortedIntegerArray(int numberElements, boolean consistentSet) {
        int[] arr = new int[numberElements];
        if (consistentSet) {
            for (int i = 0; i < numberElements; i++) {
                arr[i] = i;
            }
        } else {
            arr[0] = (int) (Math.random()*10);
            for (int i = 1; i < numberElements; i++) {
                arr[i] = (int) (Math.random() * 10) + arr[i-1];
            }
        }
        return arr;
    }
}
