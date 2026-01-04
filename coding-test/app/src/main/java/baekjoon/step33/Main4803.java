package baekjoon.step33;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main4803 {

  static List<Integer>[] graph;
  static boolean[] visited;
  static boolean hasCycle;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    int caseNum = 1;

    while (true) {
      st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());

      if (n == 0 && m == 0) {
        break;
      }

      graph = new ArrayList[n + 1];
      visited = new boolean[n + 1];

      for (int i = 1; i <= n; i++) {
        graph[i] = new ArrayList<>();
      }

      for (int i = 0; i < m; i++) {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        graph[a].add(b);
        graph[b].add(a);
      }

      int treeCount = 0;

      for (int i = 1; i <= n; i++) {
        if (!visited[i]) {
          hasCycle = false;
          dfs(i, 0);
          if (!hasCycle) {
            treeCount++;
          }
        }
      }

      sb.append("Case ").append(caseNum++).append(": ");
      if (treeCount == 0) {
        sb.append("No trees.");
      } else if (treeCount == 1) {
        sb.append("There is one tree.");
      } else {
        sb.append("A forest of ").append(treeCount).append(" trees.");
      }
      sb.append('\n');
    }

    System.out.print(sb);
  }

  static void dfs(int cur, int parent) {
    visited[cur] = true;

    for (int next : graph[cur]) {
      if (!visited[next]) {
        dfs(next, cur);
      } else if (next != parent) {
        hasCycle = true;
      }
    }
  }
}
