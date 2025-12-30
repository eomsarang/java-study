package baekjoon.step33;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main11725 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    ArrayList<Integer>[] graph = new ArrayList[N + 1];
    for (int i = 1; i <= N; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < N - 1; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      graph[a].add(b);
      graph[b].add(a);
    }

    int[] parent = new int[N + 1];
    boolean[] visited = new boolean[N + 1];

    Queue<Integer> q = new LinkedList<>();
    q.offer(1);
    visited[1] = true;

    while (!q.isEmpty()) {
      int cur = q.poll();

      for (int next : graph[cur]) {
        if (!visited[next]) {
          visited[next] = true;
          parent[next] = cur;
          q.offer(next);
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 2; i <= N; i++) {
      sb.append(parent[i]).append('\n');
    }

    System.out.print(sb);
  }
}
