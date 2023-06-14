import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int arr[][] = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = s.nextInt();
            arr[i][1] = s.nextInt();
        }

        // arr[n][0]에 대해 오름차순으로 정렬했을 때, arr[n][1]에 대해 가장 긴 오름차순 수열을 찾고 그 외의 것들을 없애야 하는 전깃줄로 간주한다,

        Arrays.sort(arr, Comparator.comparingInt((int[] o) -> o[0])); // 첫번째 숫자 기준 오름차순

        int dp[] = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (dp[i] < dp[j] + 1 && arr[i][1] > arr[j][1]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer = Math.max(dp[i], answer);
        }

        System.out.println(n - answer);


    }

}