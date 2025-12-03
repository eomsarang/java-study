package baekjoon.step29;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1753 {

  static class Node implements Comparable<Node> {

    int to, weight;

    Node(int to, int weight) {
      this.to = to;
      this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
      return this.weight - o.weight;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int V = Integer.parseInt(st.nextToken());
    int E = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(br.readLine());

    List<Node>[] graph = new ArrayList[V + 1];
    for (int i = 1; i <= V; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());
      graph[u].add(new Node(v, w));
    }

    int INF = Integer.MAX_VALUE;
    int[] dist = new int[V + 1];
    Arrays.fill(dist, INF);
    dist[K] = 0;

    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.offer(new Node(K, 0));

    while (!pq.isEmpty()) {
      Node now = pq.poll();
      int cur = now.to;

      // 이미 더 짧은 경로가 있다면 스킵
      if (now.weight > dist[cur]) {
        continue;
      }

      for (Node next : graph[cur]) {
        int newDist = dist[cur] + next.weight;

        if (newDist < dist[next.to]) {
          dist[next.to] = newDist;
          pq.offer(new Node(next.to, newDist));
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= V; i++) {
      if (dist[i] == INF) {
        sb.append("INF\n");
      } else {
        sb.append(dist[i]).append("\n");
      }
    }

    System.out.print(sb);
  }
}
