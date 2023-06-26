import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int array[][];
    static int dp[][];
    static int answer = 0;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int N;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        array = new int[N][N];

        dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int dfs = dfs(i, j);
                if (dfs > answer) {
                    answer = dfs;
                }
            }
        }

        System.out.println(answer);

    }

    public static int dfs(int x, int y) {

        if (dp[x][y] != 0) {
            return dp[x][y];
        } else {
            dp[x][y] = 1;
            for (int i = 0; i < 4; i++) {
                int defX = x + dx[i];
                int defY = y + dy[i];

                if (defX >= 0 && defX < N && defY >= 0 && defY < N) {
                    if (array[x][y] < array[defX][defY]) {
                        dp[x][y] = Math.max(dp[x][y], dfs(defX, defY) + 1);
                    }
                }

            }
        }

        return dp[x][y];


    }


}
