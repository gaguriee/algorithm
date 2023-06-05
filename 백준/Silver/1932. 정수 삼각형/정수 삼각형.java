import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int tri[][] = new int[n][n];
        // 삼각형 채우기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                tri[i][j] = sc.nextInt();
            }
        }

        System.out.println(solution(tri));

    }

    public static int solution(int[][] triangle) {

        int leng = triangle.length;
        int dp[][] = new int[leng][leng];

        dp[0][0] = triangle[0][0];

        for (int i = 1; i < leng; i++) {

            // 맨 왼쪽
            dp[i][0] = triangle[i][0] + dp[i - 1][0];

            // 중간
            for (int j = 1; j < i; j++) {
                dp[i][j] = triangle[i][j] + Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
            }
            
            // 멘 오른쪽
            dp[i][i] = triangle[i][i] + dp[i - 1][i - 1];

        }


        int answer = 0;

        for (int i = 0; i < leng; i++) {
            answer = Math.max(dp[leng - 1][i], answer); // cost가 가장 높은 것 추리기
        }


        return answer;

    }

}