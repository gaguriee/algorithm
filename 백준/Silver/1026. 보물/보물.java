import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int A[] = new int[n];
        Integer B[] = new Integer[n];

        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }

        Arrays.sort(A);

        for (int i = 0; i < n; i++) {
            B[i] = scanner.nextInt();
        }

        Arrays.sort(B, Collections.reverseOrder());

        int ans = 0;

        for (int i = 0; i < n; i++) {
            ans += A[i] * B[i];
        }

        System.out.println(ans);

    }

}