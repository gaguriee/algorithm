import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int volume[];
    static boolean visited[][];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        volume = new int[3];

        for (int i = 0; i < 3; i++) {
            volume[i] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[volume[0] + 1][volume[1] + 1];

        dfs(0, 0);

        StringBuilder sb = new StringBuilder();

        for (int i = volume[1]; i >= 0; i--) {
            if (visited[0][i]) {
                sb.append(volume[2] - i).append(" ");
            }
        }
        System.out.println(sb);

    }

    public static void dfs(int A, int B) {

        if (visited[A][B]) {
            return;
        }
        visited[A][B] = true;

        int C = volume[2] - A - B;

        int spaceA = volume[0] - A;
        int spaceB = volume[1] - B;
        int spaceC = volume[2] - C;

        if (A > 0) {
            int moveAtoB = Math.min(A, spaceB);
            dfs(A - moveAtoB, B + moveAtoB);

            int moveAtoC = Math.min(A, spaceC);
            dfs(A - moveAtoC, B);
        }

        if (B > 0) {
            int moveBtoA = Math.min(B, spaceA);
            dfs(A + moveBtoA, B - moveBtoA);

            int moveBtC = Math.min(B, spaceC);
            dfs(A, B - moveBtC);
        }

        if (C > 0) {
            int moveCtoA = Math.min(C, spaceA);
            dfs(A + moveCtoA, B);

            int moveCtB = Math.min(C, spaceB);
            dfs(A, B + moveCtB);
        }


    }


}
