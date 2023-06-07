import java.util.Scanner;

public class Main {

    static int[] seq;
    static int[] dp;
    static int num;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        num = scanner.nextInt();
        seq = new int[num];
        dp = new int[num]; // cost

        for (int i = 0; i < num; i++) {
            seq[i] = scanner.nextInt();
        }

        LIS();

        int answer = 0;
        for (int i = 0; i < num; i++) {
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);

    }

    public static void LIS() {
        for (int i = 0; i < num; i++) {

            dp[i] = seq[i];

            for (int j = 0; j < i; j++) {
                if (seq[j] < seq[i] && dp[i] < dp[j] + seq[i]) {
                    dp[i] = dp[j] + seq[i];
                }
            }

        }
    }

}