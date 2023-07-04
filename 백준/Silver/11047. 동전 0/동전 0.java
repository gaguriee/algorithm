import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int arr[] = new int[k];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int sum = k;
        int cnt = 0;
        for (int i = n - 1; i >= 0; i--) {
            cnt += sum / arr[i];
            sum = sum % arr[i];
        }

        System.out.println(cnt);
    }
}