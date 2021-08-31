/*
Условие:
Дано два непустых связных списка, которые представляют собой два неотрицательных
целых числа (натуральные числа) - числа в листах хранятся в обратном порядке
и каждая и нод содержит только одну цифру
Мы должны сложить эти два числа и вернуть результат в обратном порядке
{2 -> 4 -> 3} + {5 -> 6 -> 4} = 342 + 465 = 807 = {7, 0, 8}
1
342
465
807
 */
public class Task2 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        System.out.println(addTwoNumbers(l1, l2));
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // наш пока пустой результат
        ListNode result = new ListNode(0);
        // указатели на первый лист, на второй лист и на результирующий лист
        ListNode pointer1 = l1, pointer2 = l2, currentNode = result;
        // хранитель избыточной единицы при сложении в столбик
        int carry = 0;
        // идем циклом по обоим листам - какой-то из листов может содержать меньше цифр
        while (pointer1 != null || pointer2 != null) {
            // если какое-то число закончилось, но второе еще живо, то пустая нода равна 0
            int x = (pointer1 != null) ? pointer1.val : 0;
            int y = (pointer2 != null) ? pointer2.val : 0;
            // складываем два значения в столбик + хранитель избыточной единицы
            int sum = carry + x + y;
            // проверяем есть ли избыточная единица
            carry = sum / 10;
            // кладем в результат остаток от деления на 10
            currentNode.next = new ListNode(sum % 10);
            // положили и пошли дальше в каждом связном списке
            currentNode = currentNode.next;
            if (pointer1 != null) pointer1 = pointer1.next;
            if (pointer2 != null) pointer2 = pointer2.next;
        }
        // если по итогу осталась 1, то кладем ее в новую ноду связного списка
        if (carry > 0) {
            currentNode.next = new ListNode(carry);
        }
        // возвращаем последнюю ноду
        return result.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return  val + " " + next;
    }
}