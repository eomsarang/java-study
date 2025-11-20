package baekjoon.step27;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main24444 {

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

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      graph[u].add(v);
      graph[v].add(u);
    }

    for (int i = 1; i <= N; i++) {
      Collections.sort(graph[i]);
    }

    bfs(R);

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= N; i++) {
      sb.append(visited[i]).append("\n");
    }
    System.out.print(sb);
  }

  static void bfs(int start) {
    Queue<Integer> q = new LinkedList<>();
    visited[start] = order++;
    q.add(start);

    while (!q.isEmpty()) {
      int cur = q.poll();

      for (int nxt : graph[cur]) {
        if (visited[nxt] == 0) {
          visited[nxt] = order++;
          q.add(nxt);
        }
      }
    }
  }
}
