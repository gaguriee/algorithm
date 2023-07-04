import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(scanner.nextInt());
        }

        Collections.sort(arr);

        int sum = 0;
        int answer = 0;

        for (int i = 0; i < n; i++) {
            sum += arr.get(i);
            answer += sum;
        }

        System.out.println(answer);

    }

}
