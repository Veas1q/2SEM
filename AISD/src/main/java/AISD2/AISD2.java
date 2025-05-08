package AISD2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AISD2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            String[] str = new String[s.length()];
            if (!(s.charAt(i) == '-' || s.charAt(i) == '+' || s.charAt(i) == '*' || s.charAt(i) == ' ')) {
                str[j] = str[j] + s.charAt(i);
            }
            if (s.charAt(i) == ' ') {
                j++;
            }
            if (s.charAt(i) == '-') {
                for (int k = 1; k < str.length; k++) {
                    System.out.println(Integer.parseInt(str[0]) - Integer.parseInt(str[k]));
                }
            }
        }
    }
}