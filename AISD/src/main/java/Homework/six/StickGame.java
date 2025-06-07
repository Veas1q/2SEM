package Homework.six;
import java.util.*;

public class StickGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<List<Integer>> moves = new ArrayList<>(n + 1);
        moves.add(new ArrayList<>()); // для i=0 (не используется)

        // Считываем допустимые ходы для каждого i
        for (int i = 1; i <= n; i++) {
            int k_i = scanner.nextInt();
            List<Integer> currentMoves = new ArrayList<>(k_i);
            for (int j = 0; j < k_i; j++) {
                currentMoves.add(scanner.nextInt());
            }
            moves.add(currentMoves);
        }

        // Динамическое программирование: dp[i] = W/L
        boolean[] dp = new boolean[n + 1]; // true = W, false = L
        dp[0] = false; // L (проигрышная позиция)

        for (int i = 1; i <= n; i++) {
            boolean isWinning = false;
            for (int move : moves.get(i)) {
                if (i - move >= 0 && !dp[i - move]) {
                    isWinning = true;
                    break;
                }
            }
            dp[i] = isWinning;
        }

        System.out.println(dp[n] ? "First" : "Second");
    }
}