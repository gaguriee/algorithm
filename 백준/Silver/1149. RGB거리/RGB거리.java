import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int array[][] = new int[n+1][3];

        for (int a = 1; a < n+1; a++ ){
            int R = sc.nextInt();
            int G = sc.nextInt();
            int B = sc.nextInt();

            array[a][0] = R + Math.min(array[a-1][1], array[a-1][2]);
            array[a][1] = G + Math.min(array[a-1][0], array[a-1][2]);
            array[a][2] = B + Math.min(array[a-1][0], array[a-1][1]);

        }

        System.out.println(Math.min(array[n][0], Math.min(array[n][1], array[n][2])));
    }
}