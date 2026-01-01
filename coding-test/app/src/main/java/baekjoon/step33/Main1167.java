package baekjoon.step33;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1167 {

  static class Edge {

    int to, cost;

    Edge(int to, int cost) {
      this.to = to;
      this.cost = cost;
    }
  }

  static ArrayList<Edge>[] graph;
  static boolean[] visited;
  static int maxDist = 0;
  static int farNode = 0;

  static void bfs(int start) {
    Arrays.fill(visited, false);
    Queue<int[]> q = new LinkedList<>();
    q.offer(new int[]{start, 0});
    visited[start] = true;

    while (!q.isEmpty()) {
      int[] cur = q.poll();
      int now = cur[0];
      int dist = cur[1];

      if (dist > maxDist) {
        maxDist = dist;
        farNode = now;
      }

      for (Edge e : graph[now]) {
        if (!visited[e.to]) {
          visited[e.to] = true;
          q.offer(new int[]{e.to, dist + e.cost});
        }
      }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int V = Integer.parseInt(br.readLine());

    graph = new ArrayList[V + 1];
    visited = new boolean[V + 1];

    for (int i = 1; i <= V; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < V; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());

      while (true) {
        int to = Integer.parseInt(st.nextToken());
        if (to == -1) {
          break;
        }
        int cost = Integer.parseInt(st.nextToken());

        graph[from].add(new Edge(to, cost));
      }
    }

    bfs(1);

    maxDist = 0;
    bfs(farNode);

    System.out.println(maxDist);
  }
}
