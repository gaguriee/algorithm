import java.util.Scanner;

public class Main {

    /**
     * -> LIS 사용 : 전체 중 가장 길게 오름차순으로 정렬된 부분을 기준으로 잡고, 나머지 값들만 옮겨주면 되기 때문
     */


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }

        int dp[] = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (dp[j] + 1 > dp[i] && arr[j] < arr[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt = Math.max(cnt, dp[i]);
        }

        System.out.println(n - cnt);

    }

}