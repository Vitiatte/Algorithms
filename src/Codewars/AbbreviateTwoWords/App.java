package Codewars.AbbreviateTwoWords;

public class App {
    public static void main(String[] args) {
        System.out.println(abbrevName("Sam Harris"));
    }

    public static String abbrevName(String name) {
        String[] arr = name.split(" ");
        return (arr[0].toCharArray()[0] + "." + arr[1].toCharArray()[0]).toUpperCase();
    }
}
