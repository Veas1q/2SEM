package ClassWork;

import java.util.Arrays;
import java.util.Random;

public class DinamicProg {
    public static void main(String[] args) {
        int a = 55;
        int[] m = new int[a * 2];
        int n = 12;
        for (int i = 0; i < m.length; i++) {
            if (i == 0) {
                m[i] = 0;
            } else if (i == 1 || i == 2) {
                m[i] = 1;
            } else {
                m[i] = m[i - 1] + m[i - 2];
            }
            if (m[i] == a) {
                System.out.println("TRUE");
            }
        }
        // 4 = 1*4 4 = 2*2 4 = 3 + 1
        int count = 0;
        int[] masSteps = new int[4];
        int[] masCountStepsToPos = new int[4];
        for (int i = 0; i < masSteps.length; i++) {
            for (int k = 0; k < masSteps.length; k++) {
                int nowPos = i;
                if (nowPos + k == i) {
                    masCountStepsToPos[i] = count++;
                    nowPos = 0;
                }
                nowPos += k;
            }
        }
        int sum = 0;
        for (int i = 0; i < masCountStepsToPos.length; i++) {
            sum += masCountStepsToPos[i];
        }
        System.out.println(sum + 1);

//        int[][] mas = new int[4][14];
//        for (int i = 0; i < mas.length; i++) {
//            for (int j = 0; j < mas[i].length; j++) {
//                mas[i] = j;
//            }
//        }
    }
}
