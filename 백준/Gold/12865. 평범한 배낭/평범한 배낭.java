import java.util.Scanner;

public class Main {

    static int num;
    static int k;

    /**
     * 참고 : https://fbtmdwhd33.tistory.com/60
     */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        num = scanner.nextInt(); // 물품 수
        k = scanner.nextInt(); // 버틸 수 있는 무게

        int[][] dp = new int[num + 1][k + 1];

        for (int i = 1; i <= num; i++) {
            int w = scanner.nextInt();
            int v = scanner.nextInt();

            for (int j = 1; j <= k; j++) {
                if (j < w) { // 현재 무게보다 해당 아이템의 무게가 많이 나간다면 저장하지 못함
                    dp[i][j] = dp[i - 1][j]; // 기본적으로 이전 아이템의 가치 저장
                    continue;
                }
                dp[i][j] = Math.max(v + dp[i - 1][j - w], dp[i - 1][j]); // 해당 아이템 저장 가능 -> 이전 아이템의 가치 OR 남은 무게 가치 + 자신의 가치 중 큰 값을 택함
            }
        }

        System.out.println(dp[num][k]);


    }

}