
import java.util.*;

public class Task1 {

    static int N;
    static Stack<Integer>[] stacks;
    static List<String> moves = new ArrayList<>();
    static Stack<Integer> buffer = new Stack<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        stacks = new Stack[N];
        for (int i = 0; i < N; i++) {
            stacks[i] = new Stack<>();
        }

        for (int i = 0; i < N; i++) {
            int k = sc.nextInt();
            int[] temp = new int[k];
            for (int j = 0; j < k; j++) {
                temp[j] = sc.nextInt();
            }
            // добавляем снизу вверх
            for (int j = k - 1; j >= 0; j--) {
                stacks[i].push(temp[j]);
            }
        }

        // решение
        if (!sortContainers()) {
            System.out.println(0);
            return;
        }

        for (String move : moves) {
            System.out.println(move);
        }
    }

    static boolean sortContainers() {
        for (int target = 0; target < N; target++) {
            int type = target + 1;

            // Обрабатываем все стопки
            for (int i = 0; i < N; i++) {
                if (i == target) continue;

                Stack<Integer> temp = new Stack<>();
                while (!stacks[i].isEmpty()) {
                    int top = stacks[i].peek();
                    if (top == type) {
                        stacks[i].pop();
                        stacks[target].push(top);
                        moves.add((i + 1) + " " + (target + 1));
                    } else {
                        temp.push(stacks[i].pop());
                        // будем возвращать позже
                    }
                }

                while (!temp.isEmpty()) {
                    int val = temp.pop();
                    // находим любую подходящую стопку, не target
                    boolean placed = false;
                    for (int j = 0; j < N; j++) {
                        if (j == i || j == target) continue;
                        stacks[j].push(val);
                        moves.add((i + 1) + " " + (j + 1));
                        placed = true;
                        break;
                    }
                    if (!placed) return false; // некуда класть
                }
            }

            // В своей стопке тоже разбираем неподходящие
            Stack<Integer> temp = new Stack<>();
            while (!stacks[target].isEmpty()) {
                int top = stacks[target].peek();
                if (top == type) break;
                temp.push(stacks[target].pop());
            }
            while (!temp.isEmpty()) {
                int val = temp.pop();
                boolean placed = false;
                for (int j = 0; j < N; j++) {
                    if (j == target) continue;
                    stacks[j].push(val);
                    moves.add((target + 1) + " " + (j + 1));
                    placed = true;
                    break;
                }
                if (!placed) return false;
            }
        }

        // проверка
        for (int i = 0; i < N; i++) {
            for (int val : stacks[i]) {
                if (val != i + 1) return false;
            }
        }

        return true;
    }
}