import java.util.HashMap;
import java.util.Map;

public class Task13 {
    public static void main(String[] args) {
        System.out.println(romanToInt("III")); // 3
        System.out.println(romanToInt("IV")); // 4
        System.out.println(romanToInt("LVIII")); // 58
        System.out.println(romanToInt("MCMXCIV")); // 1994
    }

    // решение здорового программиста
    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'V' || s.charAt(i) == 'X') {
                if (i > 0 && s.charAt(i - 1) == 'I') sum -= 2;
            }
            if (s.charAt(i) == 'L' || s.charAt(i) == 'C') {
                if (i > 0 && s.charAt(i - 1) == 'X') sum -= 20;
            }
            if (s.charAt(i) == 'D' || s.charAt(i) == 'M') {
                if (i > 0 && s.charAt(i - 1) == 'C') sum -= 200;
            }
            sum += map.get(s.charAt(i));
        }

        return sum;
    }

    // как всегда мое тупое решение - решение курильщика
    public static int myStupidDecision(String s) {
        if (s.length() < 1 || s.length() > 15) return 0;
        char[] array = s.toCharArray();

        int result = 0;
        for (int i = 0; i < array.length; i++) {
            switch (array[i]) {

                case 'I':
                    if (i + 1 >= array.length) {
                        result += 1;
                    } else if (array[i + 1] == 'V') {
                        result += 4;
                        i++;
                    } else if (array[i + 1] == 'X') {
                        result += 9;
                        i++;
                    } else {
                        result += 1;
                    }
                    break;

                case 'V':
                    result += 5;
                    break;

                case 'X':
                    if (i + 1 >= array.length) {
                        result += 1;
                    } else if (array[i + 1] == 'L') {
                        result += 40;
                        i++;
                    } else if (array[i + 1] == 'C') {
                        result += 90;
                        i++;
                    } else {
                        result += 10;
                    }
                    break;

                case 'L':
                    result += 50;
                    break;

                case 'C':
                    if (i + 1 >= array.length) {
                        result += 1;
                    } else if (array[i + 1] == 'D') {
                        result += 400;
                        i++;
                    } else if (array[i + 1] == 'M') {
                        result += 900;
                        i++;
                    } else {
                        result += 10;
                    }
                    break;

                case 'D':
                    result += 500;
                    break;

                case 'M':
                    result += 1000;
                    break;
            }
        }
        return result;
    }
}
