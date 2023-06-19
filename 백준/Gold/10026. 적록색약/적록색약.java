import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static boolean visited[][];
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static char[][] ch;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ch = new char[N][N];

        for (int i = 0; i < N; i++) {
            ch[i] = br.readLine().toCharArray();
        }

        int answer[] = new int[2];
        for (int i = 0; i < 2; i++) {
            visited = new boolean[N][N];
            answer[i] = 0;
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    if (!visited[x][y]) {
                        dfs(x, y, ch[x][y]); // 이웃한 ch 중 같은 구역 범위까지 visted true로 만들음
                        answer[i]++;
                    }
                    if (ch[x][y] == 'G') {
                        ch[x][y] = 'R';
                    }
                }
            }
        }

        System.out.print(answer[0] + " " + answer[1]);

    }

    public static void dfs(int x, int y, char target) {
        if (visited[x][y]) {
            return;
        }

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int curx = x + dx[i], cury = y + dy[i]; // 현재 좌표 x, y를 기준으로 상,하,좌,우에 위치한 좌표값들
            if (curx >= 0 && curx < N && cury >= 0 && cury < N && ch[curx][cury] == target) { // 해당 좌표값이 동일한 구역에 속할 경우
                dfs(curx, cury, target);
            }
        }
    }

}
