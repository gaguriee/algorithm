import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    static int array[][];
    static boolean visited[][];
    static ArrayList<String> answer;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        array = new int[5][5];

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[5][5];

        answer = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(i, j, 0, "");
            }
        }

        // 중복 제거
        List<String> newList = answer.stream().distinct().collect(Collectors.toList());

        // 결과 출력
        System.out.println(newList.size());

    }

    public static void dfs(int i, int j, int cnt, String ans) {
        if (cnt == 6) {
            answer.add(ans);
            return;
        }

        for (int x = 0; x < 4; x++) {
            int curx = i + dx[x], cury = j + dy[x]; // 현재 좌표 x, y를 기준으로 상,하,좌,우에 위치한 좌표값들
            if (curx >= 0 && curx < 5 && cury >= 0 && cury < 5) { // 해당 좌표값이 동일한 구역에 속할 경우
                dfs(curx, cury, cnt + 1, ans + array[i][j]);
            }
        }
    }

}
