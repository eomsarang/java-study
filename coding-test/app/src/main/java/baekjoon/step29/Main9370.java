package baekjoon.step29;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main9370 {

  static class Node implements Comparable<Node> {

    int v, w;

    Node(int v, int w) {
      this.v = v;
      this.w = w;
    }

    public int compareTo(Node o) {
      return this.w - o.w;
    }
  }

  static final int INF = Integer.MAX_VALUE;

  static int n, m, t;
  static int s, g, h;
  static List<Node>[] adj;

  static int[] dijkstra(int start) {
    int[] dist = new int[n + 1];
    Arrays.fill(dist, INF);
    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.add(new Node(start, 0));
    dist[start] = 0;

    while (!pq.isEmpty()) {
      Node cur = pq.poll();
      if (cur.w > dist[cur.v]) {
        continue;
      }

      for (Node nxt : adj[cur.v]) {
        int nd = cur.w + nxt.w;
        if (nd < dist[nxt.v]) {
          dist[nxt.v] = nd;
          pq.add(new Node(nxt.v, nd));
        }
      }
    }
    return dist;
  }

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());

    while (T-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      n = Integer.parseInt(st.nextToken());
      m = Integer.parseInt(st.nextToken());
      t = Integer.parseInt(st.nextToken());

      st = new StringTokenizer(br.readLine());
      s = Integer.parseInt(st.nextToken());
      g = Integer.parseInt(st.nextToken());
      h = Integer.parseInt(st.nextToken());

      adj = new ArrayList[n + 1];
      for (int i = 1; i <= n; i++) {
        adj[i] = new ArrayList<>();
      }

      int ghLen = 0;

      for (int i = 0; i < m; i++) {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        adj[a].add(new Node(b, d));
        adj[b].add(new Node(a, d));

        if ((a == g && b == h) || (a == h && b == g)) {
          ghLen = d;
        }
      }

      int[] candidates = new int[t];
      for (int i = 0; i < t; i++) {
        candidates[i] = Integer.parseInt(br.readLine());
      }
      Arrays.sort(candidates);

      int[] distS = dijkstra(s);
      int[] distG = dijkstra(g);
      int[] distH = dijkstra(h);

      for (int x : candidates) {
        long via1 = (long) distS[g] + ghLen + distH[x];
        long via2 = (long) distS[h] + ghLen + distG[x];

        if (distS[x] == via1 || distS[x] == via2) {
          sb.append(x).append(" ");
        }
      }
      sb.append("\n");
    }

    System.out.print(sb);
  }
}
