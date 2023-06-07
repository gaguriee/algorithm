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

        LDS();

        int answer = 0;
        for (int i = 0; i < num; i++) {
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);

    }

    public static void LDS() {
        for (int i = num - 1; i >= 0; i--) {

            dp[i] = 1;

            for (int j = num - 1; j > i; j--) {
                if (seq[j] < seq[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }

        }
    }

}