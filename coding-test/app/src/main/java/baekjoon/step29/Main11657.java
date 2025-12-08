package baekjoon.step29;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main11657 {

  static class Edge {

    int from, to, cost;

    Edge(int from, int to, int cost) {
      this.from = from;
      this.to = to;
      this.cost = cost;
    }
  }

  static final long INF = Long.MAX_VALUE;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    List<Edge> edges = new ArrayList<>();
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int A = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());
      int C = Integer.parseInt(st.nextToken());
      edges.add(new Edge(A, B, C));
    }

    long[] dist = new long[N + 1];
    Arrays.fill(dist, INF);
    dist[1] = 0; // 출발점

    for (int i = 0; i < N - 1; i++) {
      for (Edge e : edges) {
        if (dist[e.from] != INF && dist[e.to] > dist[e.from] + e.cost) {
          dist[e.to] = dist[e.from] + e.cost;
        }
      }
    }

    for (Edge e : edges) {
      if (dist[e.from] != INF && dist[e.to] > dist[e.from] + e.cost) {
        System.out.println(-1);
        return;
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 2; i <= N; i++) {
      if (dist[i] == INF) {
        sb.append("-1\n");
      } else {
        sb.append(dist[i]).append("\n");
      }
    }

    System.out.print(sb);
  }
}
