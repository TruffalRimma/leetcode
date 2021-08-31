import java.util.*;

public class Task12 {
    public static void main(String[] args) {
        System.out.println(simpleOne(1234));
    }

//    public static String smarterCase(int x) {
//
//    }

    public static String simpleOne(int x) {
        String[] thousands = {"", "M", "MM", "MMM"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] units = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        return thousands[x / 1000] + hundreds[(x%1000) / 100] + tens[(x % 100) / 10] + units[x % 10];
    }
}
