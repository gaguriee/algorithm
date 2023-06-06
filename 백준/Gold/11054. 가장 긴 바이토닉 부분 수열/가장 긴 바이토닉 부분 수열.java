import java.util.Scanner;

public class Main {

    /**
     * 바이토닉 수열 구하기
     * <p>
     * 계속 증가하는 수열 LIS
     * 계속 감소하는 수열 LDS
     * 증가 후 감소
     */


    static int num;
    static int[] bt;
    static int[] lis_dp;
    static int[] lds_dp;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        num = scanner.nextInt();

        lis_dp = new int[num]; // LIS
        lds_dp = new int[num]; // LDS
        bt = new int[num];


        for (int i = 0; i < num; i++) {
            bt[i] = scanner.nextInt();
        }

        LIS();
        LDS();

        int answer = 0;
        for (int i = 0; i < num; i++) {
            answer = Math.max(lis_dp[i] + lds_dp[i], answer);
        }

        System.out.println(answer - 1);

    }

    static void LIS() {

        for (int i = 0; i < num; i++) {
            lis_dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if (bt[i] > bt[j] && lis_dp[i] < lis_dp[j] + 1) {
                    lis_dp[i] = lis_dp[j] + 1;
                }
            }
        }

    }


    static void LDS() {

        for (int i = num - 1; i >= 0; i--) {
            lds_dp[i] = 1;

            for (int j = num - 1; j > i; j--) {
                if (bt[i] > bt[j] && lds_dp[i] < lds_dp[j] + 1) {
                    lds_dp[i] = lds_dp[j] + 1;
                }
            }
        }

    }


}