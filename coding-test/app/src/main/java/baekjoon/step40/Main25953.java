package baekjoon.step40;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main25953 {

  static class Edge {

    int u, v, w;

    Edge(int u, int v, int w) {
      this.u = u;
      this.v = v;
      this.w = w;
    }
  }

  static final long INF = Long.MAX_VALUE / 4;

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int t = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    int s = Integer.parseInt(st.nextToken());
    int e = Integer.parseInt(st.nextToken());

    long[] dist = new long[n];
    Arrays.fill(dist, INF);
    dist[s] = 0;

    for (int time = 1; time <= t; time++) {

      ArrayList<Edge> edges = new ArrayList<>();

      for (int i = 0; i < m; i++) {
        st = new StringTokenizer(br.readLine());
        int u = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        edges.add(new Edge(u, v, w));
      }

      long[] nextDist = Arrays.copyOf(dist, n);

      for (Edge ed : edges) {
        if (dist[ed.u] != INF) {
          nextDist[ed.v] =
              Math.min(nextDist[ed.v], dist[ed.u] + ed.w);
        }
        if (dist[ed.v] != INF) {
          nextDist[ed.u] =
              Math.min(nextDist[ed.u], dist[ed.v] + ed.w);
        }
      }

      dist = nextDist;
    }

    if (dist[e] == INF) {
      System.out.println(-1);
    } else {
      System.out.println(dist[e]);
    }
  }
}
