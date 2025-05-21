package Homework.third;

public class Second {
    public static void main(String[] args) {
        int[] mas1 = {5, 4, 3, 2, 1, 7, 77, 87};
//        Есть строка.
//        Нужно развернуть строку так, чтобы каждое из слов осталось в естественном порядке.
//        Например. Input 1: A = "the sky is blue" Output 1: "blue is sky the"
//        Input 2: A = "this is ib"    Output 2: "ib is this". Сложность линейная, с О(1) дополнительной памяти.
//        как будто задачу не решить с дополнительной памятью O(n)
        String s1 = "the sky is blue";
        String s2 = "blue is sky the";
        String[] masS1 = s1.split(" ");
        String[] masS2 = s2.split(" ");
        StringBuilder rS1 = new StringBuilder();
        for (int i = masS1.length - 1; i >= 0; i--) {
            rS1.append(masS1[i] + " ");
        }

        rS1.toString();
        System.out.println(rS1);
    }
}
