package baekjoon.step27;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1707 {

  static ArrayList<Integer>[] graph;
  static int[] color;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int K = Integer.parseInt(br.readLine());

    while (K-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int V = Integer.parseInt(st.nextToken());
      int E = Integer.parseInt(st.nextToken());

      graph = new ArrayList[V + 1];
      color = new int[V + 1];

      for (int i = 1; i <= V; i++) {
        graph[i] = new ArrayList<>();
      }

      for (int i = 0; i < E; i++) {
        st = new StringTokenizer(br.readLine());
        int u = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        graph[u].add(v);
        graph[v].add(u);
      }

      sb.append(isBipartite(V) ? "YES\n" : "NO\n");
    }

    System.out.print(sb);
  }

  static boolean isBipartite(int V) {
    for (int i = 1; i <= V; i++) {
      if (color[i] == 0) {
        if (!bfs(i)) {
          return false;
        }
      }
    }
    return true;
  }

  static boolean bfs(int start) {
    Queue<Integer> q = new LinkedList<>();
    q.add(start);
    color[start] = 1;

    while (!q.isEmpty()) {
      int now = q.poll();

      for (int next : graph[now]) {
        if (color[next] == 0) {
          color[next] = -color[now];
          q.add(next);
        } else if (color[next] == color[now]) {
          return false;
        }
      }
    }
    return true;
  }
}
