package baekjoon.step27;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main24480 {

  static ArrayList<Integer>[] graph;
  static int[] visited;
  static int order = 1;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int R = Integer.parseInt(st.nextToken());

    graph = new ArrayList[N + 1];
    visited = new int[N + 1];

    for (int i = 1; i <= N; i++) {
      graph[i] = new ArrayList<>();
    }

    // 간선 입력
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      graph[u].add(v);
      graph[v].add(u);
    }

    for (int i = 1; i <= N; i++) {
      Collections.sort(graph[i], Collections.reverseOrder());
    }

    dfs(R);

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= N; i++) {
      sb.append(visited[i]).append('\n');
    }
    System.out.print(sb);
  }

  static void dfs(int node) {
    visited[node] = order++;

    for (int nxt : graph[node]) {
      if (visited[nxt] == 0) {
        dfs(nxt);
      }
    }
  }
}
