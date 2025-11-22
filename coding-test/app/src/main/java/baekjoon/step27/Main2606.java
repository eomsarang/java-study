package baekjoon.step27;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main2606 {

  static ArrayList<Integer>[] graph;
  static boolean[] visited;
  static int count = 0;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int m = Integer.parseInt(br.readLine());

    graph = new ArrayList[n + 1];
    visited = new boolean[n + 1];

    for (int i = 1; i <= n; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < m; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      graph[a].add(b);
      graph[b].add(a);
    }

    dfs(1);

    System.out.println(count - 1);
  }

  static void dfs(int node) {
    visited[node] = true;
    count++;

    for (int next : graph[node]) {
      if (!visited[next]) {
        dfs(next);
      }
    }
  }
}
