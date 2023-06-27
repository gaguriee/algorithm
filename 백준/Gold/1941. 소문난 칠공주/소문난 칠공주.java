import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    // TODO : 다시 풀기
    
    static char map[][] = new char[5][5];
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static int combX[] = new int[25];
    static int combY[] = new int[25];
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            map[i] = sc.next().toCharArray();
        }


        /* 좌표 미리 계산 */
        for (int i = 0; i < 25; i++) {
            combX[i] = i % 5;
            combY[i] = i / 5;
        }

        combination(new int[7], 0, 0);
        System.out.println(answer);

    }

    // 조합 생성
    public static void combination(int[] comb, int idx, int depth) {

        // 7개의 조합이 생성되면 bfs를 통해 서로 이웃하는지 확인
        if (idx == 7) {
            bfs(comb);
            return;
        }

        if (depth == 25) return;

        comb[idx] = depth;
        combination(comb, idx + 1, depth + 1);    // 선택한 경우
        combination(comb, idx, depth + 1);    // 선택하지 않은 경우
    }

    public static void bfs(int comb[]) {
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[7];

        visited[0] = true;
        q.add(comb[0]);
        int cnt = 1, sCnt = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (map[combY[cur]][combX[cur]] == 'S') sCnt++;

            for (int i = 0; i < 4; i++) {
                for (int next = 1; next < 7; next++) {
                    if (!visited[next] && combX[cur] + dx[i] == combX[comb[next]] && combY[cur] + dy[i] == combY[comb[next]]) {
                        visited[next] = true;
                        q.add(comb[next]);
                        cnt++;
                    }
                }
            }
        }

        if (cnt == 7) {
            if (sCnt >= 4) {
                answer++;
            }
        }

    }

}