import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int cnt = scanner.nextInt();

        int[][] arr = new int[cnt][2];


        for (int i = 0; i<cnt; i++){
            arr[i][0] = scanner.nextInt(); // 시작 시간
            arr[i][1] = scanner.nextInt(); // 종료 시간
        }
        
        Arrays.sort(arr, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }

                return o1[1] - o2[1];
            }

        });

        int count = 0;
        int prev_end_time = 0;

        for (int i =0; i<cnt;i++){
            if (prev_end_time <= arr[i][0]){
                prev_end_time = arr[i][1];
                count++;
            }
        }

        System.out.println(count);

    }
}