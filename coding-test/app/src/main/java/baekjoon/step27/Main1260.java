package baekjoon.step27;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1260 {

  static ArrayList<Integer>[] graph;
  static boolean[] visited;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int V = Integer.parseInt(st.nextToken());

    graph = new ArrayList[N + 1];

    for (int i = 1; i <= N; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      graph[a].add(b);
      graph[b].add(a);
    }

    for (int i = 1; i <= N; i++) {
      Collections.sort(graph[i]);
    }

    visited = new boolean[N + 1];
    dfs(V);
    sb.append("\n");

    visited = new boolean[N + 1];
    bfs(V);

    System.out.print(sb.toString());
  }

  static void dfs(int node) {
    visited[node] = true;
    sb.append(node).append(" ");

    for (int next : graph[node]) {
      if (!visited[next]) {
        dfs(next);
      }
    }
  }

  static void bfs(int start) {
    Queue<Integer> q = new LinkedList<>();
    visited[start] = true;
    q.add(start);

    while (!q.isEmpty()) {
      int cur = q.poll();
      sb.append(cur).append(" ");

      for (int next : graph[cur]) {
        if (!visited[next]) {
          visited[next] = true;
          q.add(next);
        }
      }
    }
  }
}
