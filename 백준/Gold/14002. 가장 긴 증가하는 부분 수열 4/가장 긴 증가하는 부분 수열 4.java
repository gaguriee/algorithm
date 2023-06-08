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
        int answer_index = 0;
        for (int i = 0; i < num; i++) {
            if (answer < dp[i]) {
                answer = dp[i];
                answer_index = i;
            }
        }

        int answer_array[] = new int[answer];
        answer_array[answer - 1] = seq[answer_index];

        System.out.println(answer);

        // 7
        // 1 6 2 4 5 3 7

        int cnt = answer;
        int ansArr[] = new int[answer];
        for (int i = num - 1; i >= 0; --i) {
            if (dp[i] == cnt) {
                --cnt;
                ansArr[cnt] = seq[i];
            }
        }

        for (int i = 0; i < ansArr.length; i++) {
            System.out.print(ansArr[i]);
            if (i < ansArr.length - 1)
                System.out.print(" ");
        }
    }

    public static void LIS() {
        for (int i = 0; i < num; i++) {

            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if (seq[j] < seq[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }

        }
    }

}