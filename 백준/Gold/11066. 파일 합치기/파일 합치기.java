import java.util.Scanner;

public class Main {

    /**
     * 무조건 인접한 것끼리 합치기
     * n=1 -> DP[i][i] = 0
     * n=2 -> DP[i][i+1] = V[i]+V[i+1]
     * n>2 -> DP[i][j] = Math.Min(DP[i][j], DP[i][k]+DP[k+1][j] + SUM(V[i~j])
     */

    static int T, K;
    static int[] arr;
    static int[] sum;
    static int[][] dp;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();

        for (int t = 0; t < T; t++) {

            K = sc.nextInt();

            arr = new int[K + 1];
            sum = new int[K + 1];
            dp = new int[502][502];

            for (int i = 1; i <= K; i++) {
                arr[i] = sc.nextInt();
                sum[i] = sum[i - 1] + arr[i];
            }

            for (int i = 2; i <= K; i++) {
                for (int j = i - 1; j > 0; j--) {
                    dp[j][i] = Integer.MAX_VALUE;
                    for (int s = j; s <= i; s++) {
                        dp[j][i] = Math.min(dp[j][i], dp[j][s] + dp[s + 1][i]);
                    }
                    dp[j][i] += sum[i] - sum[j - 1];
                }
            }

            System.out.println(dp[1][K]);

        }
        sc.close();

    }
}
