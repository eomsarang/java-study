package baekjoon.step35;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1197 {

  static class Edge implements Comparable<Edge> {

    int from, to;
    int weight;

    Edge(int from, int to, int weight) {
      this.from = from;
      this.to = to;
      this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
      return Integer.compare(this.weight, o.weight);
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
    StringTokenizer st = new StringTokenizer(br.readLine());

    int V = Integer.parseInt(st.nextToken());
    int E = Integer.parseInt(st.nextToken());

    Edge[] edges = new Edge[E];
    for (int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine());
      int A = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());
      int C = Integer.parseInt(st.nextToken());
      edges[i] = new Edge(A, B, C);
    }

    Arrays.sort(edges);

    parent = new int[V + 1];
    for (int i = 1; i <= V; i++) {
      parent[i] = i;
    }

    long mstWeight = 0;
    int count = 0;

    for (Edge edge : edges) {
      if (union(edge.from, edge.to)) {
        mstWeight += edge.weight;
        count++;
        if (count == V - 1) {
          break;
        }
      }
    }

    System.out.println(mstWeight);
  }
}
