package util;

public class ConsolePrinter {
    public static void printIntArray(int[] arr, boolean everyRecordInNewLine, boolean useWrapper) {
        if (everyRecordInNewLine) {
            for (int i: arr) {
                String s = useWrapper ? "[" + i + "]" : i + " ";
                System.out.println(s);
            }
        } else {
            for (int i : arr) {
                String s = useWrapper ? "[" + i + "]" : i + " ";
                System.out.print(s);
            }
            System.out.println();
        }
    }
}
