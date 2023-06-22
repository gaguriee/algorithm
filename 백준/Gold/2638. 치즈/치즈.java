import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int array[][];
    static int new_array[][];
    static int M, N;
    static int answer;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean flag = true;
    static boolean visited[][];

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        array = new int[N][M];
        new_array = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int token = 0;
                token = Integer.parseInt(st.nextToken());
                array[i][j] = token;
                new_array[i][j] = token;
            }
        }

        answer = 0;

        int time = 0;

        // 외부 공기 2로 구별하기
        visited = new boolean[N][M];
        externalAir(0, 0);

        while (flag) {
            time++;
            flag = false;
            visited = new boolean[N][M];
            externalAir(0, 0);
            for (int i = 1; i < N - 1; i++) {
                for (int j = 1; j < M - 1; j++) {
                    dfs(i, j);
                }
            }


            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int token = new_array[i][j];
                    array[i][j] = token;
                }
            }

        }

        System.out.println(time - 1);

    }

    // 외부 공기 2로 만들기
    public static void externalAir(int x, int y) {
        if (array[x][y] == 1 && visited[x][y]) {
            return;
        }

        visited[x][y] = true;

        array[x][y] = 2;
        new_array[x][y] = 2;

        for (int i = 0; i < 4; i++) {
            int defX = x + dx[i];
            int defY = y + dy[i];
            if (defX < N && defX >= 0 && defY < M && defY >= 0 && array[defX][defY] != 1 && !visited[defX][defY]) {
                // 외부 공기라면
                externalAir(defX, defY);
            }
        }
    }

    // 치즈 녹이기
    public static void dfs(int x, int y) {

        // 치즈 내부에 있는 공간은 치즈 외부 공기와 접촉하지 않는 것으로 가정
        // 상하좌우 중 2변 이상이 2이면 2로 바꾸기 (외부공기와 만나면 외부공기가 됨)

        int cnt = 0;


        for (int i = 0; i < 4; i++) {
            int defX = x + dx[i];
            int defY = y + dy[i];
            if (array[defX][defY] == 2) {
                // 외부 공기라면
                cnt++;
            }
        }

        if (cnt >= 2 && array[x][y] == 1) {
            flag = true;
            new_array[x][y] = 2;
        }
    }


}
