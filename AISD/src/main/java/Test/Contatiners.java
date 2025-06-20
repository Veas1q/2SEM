import java.util.Scanner;

public class Contatiners {

    static class Elem {
        int val;
        Elem pr;
    }

    static class MyStack {
        Elem up;

        MyStack() {
            up = null;
        }

        void push(int a) {
            Elem tmp = new Elem();
            tmp.val = a;
            tmp.pr = up;
            up = tmp;
        }

        int pop() {
            if (up != null) {
                int v = up.val;
                Elem tmp = up;
                up = up.pr;
                return v;
            } else {
                System.err.println("empty stack");
                return 0;
            }
        }

        int back() {
            return up.val;
        }

        boolean empty() {
            return up == null;
        }

        void free() {
            while (!empty()) pop();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        MyStack[] cont = new MyStack[501];
        for (int i = 0; i < cont.length; i++) {
            cont[i] = new MyStack();
        }

        if (N == 2) {
            boolean ok = true, first = true;
            int k = scanner.nextInt();
            int j = 0;
            if (k != 0) {
                int tmp = scanner.nextInt();
                int i = 1;
                while (tmp == 1 && i < k) {
                    tmp = scanner.nextInt();
                    i++;
                }
                j = tmp == 2 ? 1 : 0;
                while (i < k) {
                    tmp = scanner.nextInt();
                    if (tmp == 1) ok = false;
                    j++;
                    i++;
                }
            }
            k = scanner.nextInt();
            if (k != 0) {
                int tmp = scanner.nextInt();
                int i = 1;
                while (tmp == 2 && i < k) {
                    tmp = scanner.nextInt();
                    i++;
                }
                if (j != 0 && tmp == 1) {
                    ok = false;
                } else if (tmp == 1) {
                    first = false;
                }
                j += tmp == 1 ? 1 : 0;
                while (i < k) {
                    tmp = scanner.nextInt();
                    if (tmp == 2) ok = false;
                    j++;
                    i++;
                }
            }
            if (ok) {
                if (first) {
                    for (int i = 0; i < j; i++) {
                        System.out.println("1 2");
                    }
                } else {
                    for (int i = 0; i < j; i++) {
                        System.out.println("2 1");
                    }
                }
            } else {
                System.out.println(0);
            }
            return;
        }

        for (int i = 1; i <= N; i++) {
            int k = scanner.nextInt();
            if (k != 0) {
                int tmp = scanner.nextInt();
                int j = 1;
                while (tmp == i && j < k) {
                    tmp = scanner.nextInt();
                    j++;
                }
                if (tmp != i) {
                    cont[i].push(tmp);
                }
                while (j < k) {
                    tmp = scanner.nextInt();
                    cont[i].push(tmp);
                    j++;
                }
            }
        }

        for (int i = 1; i < N; i++) {
            while (!cont[i].empty()) {
                while (!cont[i].empty() && cont[cont[i].back()].empty()) {
                    System.out.println(i + " " + cont[i].pop());
                }
                while (!cont[i].empty() && !cont[cont[i].back()].empty()) {
                    System.out.println(i + " " + N);
                    cont[N].push(cont[i].pop());
                }
            }
            while (!cont[i].empty()) {
                System.out.println(i + " " + N);
                cont[N].push(cont[i].pop());
            }
        }

        int save = 1;
        int qsave = 0;
        while (!cont[N].empty()) {
            int tmp = cont[N].pop();
            if (tmp == N) {
                System.out.println(N + " " + save);
                qsave++;
            } else if (tmp == save) {
                save = 1 + save % 2;
                for (int i = 0; i < qsave; i++) {
                    System.out.println(tmp + " " + save);
                }
                System.out.println(N + " " + tmp);
            } else {
                System.out.println(N + " " + tmp);
            }
        }

        for (int i = 0; i < qsave; i++) {
            System.out.println(save + " " + N);
        }
    }
}