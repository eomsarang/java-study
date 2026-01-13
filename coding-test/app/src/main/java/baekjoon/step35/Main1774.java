package baekjoon.step35;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main1774 {

  static class Edge implements Comparable<Edge> {

    int a, b;
    double cost;

    Edge(int a, int b, double cost) {
      this.a = a;
      this.b = b;
      this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
      return Double.compare(this.cost, o.cost);
    }
  }

  static int[] parent;

  static int find(int x) {
    if (parent[x] == x) {
      return x;
    }
    return parent[x] = find(parent[x]);
  }

  static void union(int a, int b) {
    a = find(a);
    b = find(b);
    if (a != b) {
      parent[b] = a;
    }
  }

  static double dist(int[] a, int[] b) {
    return Math.sqrt(
        Math.pow(a[0] - b[0], 2) +
            Math.pow(a[1] - b[1], 2)
    );
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[][] pos = new int[N + 1][2];
    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      pos[i][0] = Integer.parseInt(st.nextToken());
      pos[i][1] = Integer.parseInt(st.nextToken());
    }

    parent = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      parent[i] = i;
    }

    // 이미 연결된 통로 union
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      union(a, b);
    }

    // 모든 간선 생성
    List<Edge> edges = new ArrayList<>();
    for (int i = 1; i <= N; i++) {
      for (int j = i + 1; j <= N; j++) {
        edges.add(new Edge(i, j, dist(pos[i], pos[j])));
      }
    }

    Collections.sort(edges);

    double answer = 0;
    for (Edge e : edges) {
      if (find(e.a) != find(e.b)) {
        union(e.a, e.b);
        answer += e.cost;
      }
    }

    System.out.printf("%.2f\n", answer);
  }
}
