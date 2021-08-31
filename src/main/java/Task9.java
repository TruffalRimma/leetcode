public class Task9 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(123));
        System.out.println(isPalindrome(-121));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x == 0) return true;
        if (x % 10 == 0) return false;

        int result = 0;
        int copy = x;

        while (x != 0) {
            int pop = x % 10;
            x /= 10;

            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && pop > 7)) return false;

            result = result * 10 + pop;
        }

        return result == copy;
    }
}
