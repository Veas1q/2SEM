package Homework.Skobki;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int min = 0;
        int[] masToSort = {12300, 42003, 7658, 987867, 234, 12};
        for (int i = 0; i < masToSort.length; i++) {
            for (int j = i; j < masToSort.length; j++) {

                min = (masToSort[j] < masToSort[min] ? j : min);
            }
            int temp = masToSort[min];
            masToSort[min] = masToSort[i];
            masToSort[i] = temp;
        }
//        System.out.println(Arrays.toString(masToSort));

        char[] mas = {'[', ']', '{', '}', '[', ']'};
        char[] mas1 = {'[', ']', '(', ']', '(', ')'};
        char[] mas3 = {'[', '[', ']', ']','[',']'};

//        for (int i = 0; i < mas.length ; i++) {
//            System.out.println((int)mas[i]);
//        }
        System.out.println(checkWithLinkedList(mas3));
    }

    public static boolean checkWithLinkedList(char[] chars) {
        if (chars.length % 2 != 0) {
            return false;
        }

        List<Character> stack = new LinkedList<>();

        for (char c : chars) {
            if (c == '(' || c == '[' || c == '{') {
                stack.add(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.removeLast();
                if (!((top == '(' && c == ')') ||
                        (top == '[' && c == ']') ||
                        (top == '{' && c == '}'))) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
