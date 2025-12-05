package baekjoon.step29;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1504 {

  static class Node implements Comparable<Node> {

    int to, weight;

    Node(int t, int w) {
      to = t;
      weight = w;
    }

    public int compareTo(Node o) {
      return this.weight - o.weight;
    }
  }

  static int N, E;
  static List<List<Node>> graph;
  static final int INF = 200000000;

  static int[] dijkstra(int start) {
    PriorityQueue<Node> pq = new PriorityQueue<>();
    int[] dist = new int[N + 1];
    Arrays.fill(dist, INF);
    dist[start] = 1;
    dist[start] = 0;
    pq.add(new Node(start, 0));

    while (!pq.isEmpty()) {
      Node cur = pq.poll();
      int now = cur.to;
      int nowW = cur.weight;

      if (dist[now] < nowW) {
        continue;
      }

      for (Node next : graph.get(now)) {
        int cost = nowW + next.weight;
        if (cost < dist[next.to]) {
          dist[next.to] = cost;
          pq.add(new Node(next.to, cost));
        }
      }
    }
    return dist;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    E = Integer.parseInt(st.nextToken());

    graph = new ArrayList<>();
    for (int i = 0; i <= N; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      graph.get(a).add(new Node(b, c));
      graph.get(b).add(new Node(a, c));
    }

    st = new StringTokenizer(br.readLine());
    int v1 = Integer.parseInt(st.nextToken());
    int v2 = Integer.parseInt(st.nextToken());

    int[] distStart = dijkstra(1);
    int[] distV1 = dijkstra(v1);
    int[] distV2 = dijkstra(v2);

    long path1 = (long) distStart[v1] + distV1[v2] + distV2[N];
    long path2 = (long) distStart[v2] + distV2[v1] + distV1[N];

    long answer = Math.min(path1, path2);
    System.out.println(answer >= INF ? -1 : answer);
  }
}
