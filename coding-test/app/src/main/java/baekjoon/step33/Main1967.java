package baekjoon.step33;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main1967 {

  static class Edge {

    int to, weight;

    Edge(int to, int weight) {
      this.to = to;
      this.weight = weight;
    }
  }

  static ArrayList<Edge>[] tree;
  static boolean[] visited;
  static int maxDist = 0;
  static int farNode = 1;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    tree = new ArrayList[n + 1];
    for (int i = 1; i <= n; i++) {
      tree[i] = new ArrayList<>();
    }

    for (int i = 0; i < n - 1; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int parent = Integer.parseInt(st.nextToken());
      int child = Integer.parseInt(st.nextToken());
      int weight = Integer.parseInt(st.nextToken());

      tree[parent].add(new Edge(child, weight));
      tree[child].add(new Edge(parent, weight));
    }

    visited = new boolean[n + 1];
    dfs(1, 0);

    visited = new boolean[n + 1];
    maxDist = 0;
    dfs(farNode, 0);

    System.out.println(maxDist);
  }

  static void dfs(int node, int dist) {
    visited[node] = true;

    if (dist > maxDist) {
      maxDist = dist;
      farNode = node;
    }

    for (Edge e : tree[node]) {
      if (!visited[e.to]) {
        dfs(e.to, dist + e.weight);
      }
    }
  }
}
