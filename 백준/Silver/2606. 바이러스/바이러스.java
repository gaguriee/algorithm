import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int N, pair, cnt;
    static boolean map[][], visited[];


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        pair = scanner.nextInt();

        map = new boolean[N + 1][N + 1];

        cnt = 0;
        visited = new boolean[N + 1];

        for (int i = 0; i < pair; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            map[a][b] = true;
            map[b][a] = true;
        }

        bfs(1);

        System.out.println(cnt);

    }

    public static void bfs(int a) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(a);
        
        visited[a] = true;
        
        while (!q.isEmpty()) {
            int temp = q.poll();

            for (int k = 1; k <= N; k++) {
                if (map[temp][k] == true && visited[k] == false) {
                    q.offer(k);
                    visited[k] = true;
                    cnt++;
                }
            }
        }
    }

}
