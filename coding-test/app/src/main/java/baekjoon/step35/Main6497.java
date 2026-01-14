package baekjoon.step35;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main6497 {

  static class Edge implements Comparable<Edge> {

    int u, v;
    int w;

    Edge(int u, int v, int w) {
      this.u = u;
      this.v = v;
      this.w = w;
    }

    @Override
    public int compareTo(Edge o) {
      return Integer.compare(this.w, o.w);
    }
  }

  static int[] parent;

  static int find(int x) {
    if (parent[x] == x) {
      return x;
    }
    return parent[x] = find(parent[x]);
  }

  static boolean union(int a, int b) {
    a = find(a);
    b = find(b);
    if (a == b) {
      return false;
    }
    parent[b] = a;
    return true;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    while (true) {
      st = new StringTokenizer(br.readLine());
      int m = Integer.parseInt(st.nextToken());
      int n = Integer.parseInt(st.nextToken());

      if (m == 0 && n == 0) {
        break;
      }

      parent = new int[m];
      for (int i = 0; i < m; i++) {
        parent[i] = i;
      }

      List<Edge> edges = new ArrayList<>();
      long totalCost = 0;

      for (int i = 0; i < n; i++) {
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int z = Integer.parseInt(st.nextToken());

        edges.add(new Edge(x, y, z));
        totalCost += z;
      }

      Collections.sort(edges);

      long mstCost = 0;
      for (Edge e : edges) {
        if (union(e.u, e.v)) {
          mstCost += e.w;
        }
      }

      System.out.println(totalCost - mstCost);
    }
  }
}
