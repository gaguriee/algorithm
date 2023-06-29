import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    static int N, cnt;
    static boolean visited[][];
    static char array[][];
    static int arrX[] = {-1, 0, 1, 0};
    static int arrY[] = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();

        array = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            array[i] = scanner.next().toCharArray();
        }


        int number = 1;
        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (array[i][j] == '1') {
                    cnt = 0;
                    dfs(i, j, number);
                    answer.add(cnt + 1);
                    number++;
                }

            }
        }


        System.out.println(number - 1);

        Collections.sort(answer);
        for (int i = 0; i < answer.size(); i++) {
            System.out.println(answer.get(i));
        }

    }

    public static void dfs(int x, int y, int num) {
        if (visited[x][y]) {
            return;
        }

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int defX = x + arrX[i];
            int defY = y + arrY[i];

            if (defX >= 0 && defX < N && defY >= 0 && defY < N && !visited[defX][defY] && array[defX][defY] == '1') {
                array[defX][defY] = (char) num;
                cnt++;
                dfs(defX, defY, num);
            }
        }

    }

}
