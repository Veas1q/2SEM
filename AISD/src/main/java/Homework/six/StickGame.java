package Homework.six;
import java.util.*;
import java.util.*;

public class StickGame {

    public static void main(String[] args) {
        // Пример входных данных
        Map<Integer, List<Integer>> moves = new HashMap<>();
        moves.put(1, List.of(1));
        moves.put(2, List.of(1, 2));
        moves.put(3, List.of(1, 2, 3));

        int n = 4;
        System.out.println(whoWins(n, moves));  // Выведет "Первый"
    }

    public static String whoWins(int n, Map<Integer, List<Integer>> moves) {
        // dp[i] = true, если текущий игрок может выиграть из позиции i
        boolean[] dp = new boolean[n + 1];

        // Базовый случай: если палочек нет - текущий игрок проигрывает
        dp[0] = false;

        for (int i = 1; i <= n; i++) {
            if (!moves.containsKey(i)) continue;

            // Проверяем все возможные ходы из текущей позиции
            for (int move : moves.get(i)) {
                // Если можем сделать ход, ведущий в проигрышную позицию для противника
                if (i - move >= 0 && !dp[i - move]) {
                    dp[i] = true;
                    break;  // Достаточно одного выигрышного хода
                }
            }
        }

        return dp[n] ? "Первый" : "Второй";
    }
}
