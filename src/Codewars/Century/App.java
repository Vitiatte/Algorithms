package Codewars.Century;

public class App {
    public static void main(String[] args) {
        System.out.println(getCentury(1945));
        System.out.println(getCentury(1900));
    }

    public static int getCentury(int year) {
        boolean additionalOne = year % 100 == 0;
        return year / 100 + (additionalOne ? 0 : 1);
    }
}
