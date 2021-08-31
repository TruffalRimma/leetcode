public class Task7 {
    public static void main(String[] args) {
        // развернуть целое число с учетом знака + учитывать диапазон инта (32 бита)
        System.out.println(reverse(-865465132)); // -231564568
        System.out.println(reverse(1534236469)); // 0
    }

    public static int reverse(int x) {
        int result = 0;
        while (x != 0) {
            // берем остаток от каждого десятичного разряда и добавляем в резалт
            int pop = x % 10;
            // само число каждый раз уменьшаем
            x /= 10;

            // проверка на диапазон
            /* сначала если больше диапазона - до расширения результата
             если после обхода цикла результат больше максимального значения инта / 10 - ибо будем увеличивать
             или
             результат равен максимальному значению инта и остаток больше 7
             Это связано с последними цифрами в MIN_VALUE и MAX_VALUE в классе Integer и у целого числа int.
             От -2,147,483,648 до +2,147,483,647
             выходим из цикла - возвращаем ноль
             */
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            // потом если меньше диапазона
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && pop < -8)) return 0;

            result = result * 10 + pop;
        }
        return result;
    }
}
