package baekjoon.step32;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main11779 {

  static class Edge {

    int to, cost;

    Edge(int to, int cost) {
      this.to = to;
      this.cost = cost;
    }
  }

  static class Node implements Comparable<Node> {

    int idx, dist;

    Node(int idx, int dist) {
      this.idx = idx;
      this.dist = dist;
    }

    public int compareTo(Node o) {
      return this.dist - o.dist;
    }
  }

  static final int INF = Integer.MAX_VALUE;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int m = Integer.parseInt(br.readLine());

    ArrayList<Edge>[] graph = new ArrayList[n + 1];
    for (int i = 1; i <= n; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < m; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      int cost = Integer.parseInt(st.nextToken());
      graph[from].add(new Edge(to, cost));
    }

    StringTokenizer st = new StringTokenizer(br.readLine());
    int start = Integer.parseInt(st.nextToken());
    int end = Integer.parseInt(st.nextToken());

    int[] dist = new int[n + 1];
    int[] parent = new int[n + 1];
    Arrays.fill(dist, INF);
    Arrays.fill(parent, -1);

    PriorityQueue<Node> pq = new PriorityQueue<>();
    dist[start] = 0;
    pq.offer(new Node(start, 0));

    while (!pq.isEmpty()) {
      Node cur = pq.poll();

      if (cur.dist > dist[cur.idx]) {
        continue;
      }

      for (Edge e : graph[cur.idx]) {
        int next = e.to;
        int newCost = dist[cur.idx] + e.cost;

        if (newCost < dist[next]) {
          dist[next] = newCost;
          parent[next] = cur.idx;
          pq.offer(new Node(next, newCost));
        }
      }
    }

    ArrayList<Integer> path = new ArrayList<>();
    int cur = end;
    while (cur != -1) {
      path.add(cur);
      cur = parent[cur];
    }
    Collections.reverse(path);

    StringBuilder sb = new StringBuilder();
    sb.append(dist[end]).append('\n');
    sb.append(path.size()).append('\n');
    for (int city : path) {
      sb.append(city).append(' ');
    }

    System.out.println(sb);
  }
}
