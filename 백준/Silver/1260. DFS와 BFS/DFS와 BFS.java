import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    /**
     * 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램
     * 참고 : https://tweety1121.tistory.com/entry/%EB%B0%B1%EC%A4%80-1260%EB%B2%88-%EC%82%AC%ED%83%95-%EA%B2%8C%EC%9E%84-%EC%9E%90%EB%B0%94-%ED%92%80%EC%9D%B4
     */
    static int[][] treeArray;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();   // 정점개수
        int M = sc.nextInt();   // 간선개수
        int V = sc.nextInt();   // 시작정점번호

        treeArray = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            // 연결된 노드를 1로 세팅
            treeArray[a][b] = 1;
            treeArray[b][a] = 1;
        }

        // node가 1부터 시작하기 때문에 N + 1
        visited = new boolean[N + 1];
        dfs(V);

        System.out.println();

        visited = new boolean[N + 1];

        bfs(V);

        System.out.println();
    }

    private static void dfs(int v) {

        visited[v] = true;

        System.out.print(v + " ");

        if (v == treeArray.length)
            return;

        for (int i = 0; i < treeArray.length; i++) {
            if (treeArray[v][i] == 1 && visited[i] == false) {
                dfs(i);
            }
        }


    }


    private static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(v);
        visited[v] = true;

        System.out.print(v + " ");

        while (!queue.isEmpty()) {
            int n = queue.poll();
            
            for (int i = 1; i < treeArray.length; i++) {
                if (treeArray[n][i] == 1 && visited[i] == false) {
                    visited[i] = true;
                    System.out.print(i + " ");
                    queue.offer(i);
                }
            }
        }
    }


}
