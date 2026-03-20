package baekjoon.step48;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main2150 {

  static int V, E;
  static ArrayList<Integer>[] graph, reverseGraph;
  static boolean[] visited;
  static Stack<Integer> stack = new Stack<>();
  static ArrayList<ArrayList<Integer>> sccList = new ArrayList<>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    V = Integer.parseInt(st.nextToken());
    E = Integer.parseInt(st.nextToken());

    graph = new ArrayList[V + 1];
    reverseGraph = new ArrayList[V + 1];

    for (int i = 1; i <= V; i++) {
      graph[i] = new ArrayList<>();
      reverseGraph[i] = new ArrayList<>();
    }

    for (int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine());
      int A = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());
      graph[A].add(B);
      reverseGraph[B].add(A);
    }

    visited = new boolean[V + 1];

    for (int i = 1; i <= V; i++) {
      if (!visited[i]) {
        dfs(i);
      }
    }

    Arrays.fill(visited, false);

    while (!stack.isEmpty()) {
      int node = stack.pop();
      if (!visited[node]) {
        ArrayList<Integer> scc = new ArrayList<>();
        reverseDfs(node, scc);
        Collections.sort(scc);
        sccList.add(scc);
      }
    }

    Collections.sort(sccList, (a, b) -> a.get(0) - b.get(0));

    StringBuilder sb = new StringBuilder();
    sb.append(sccList.size()).append("\n");

    for (ArrayList<Integer> scc : sccList) {
      for (int x : scc) {
        sb.append(x).append(" ");
      }
      sb.append("-1\n");
    }

    System.out.print(sb);
  }

  static void dfs(int node) {
    visited[node] = true;
    for (int next : graph[node]) {
      if (!visited[next]) {
        dfs(next);
      }
    }
    stack.push(node);
  }

  static void reverseDfs(int node, ArrayList<Integer> scc) {
    visited[node] = true;
    scc.add(node);
    for (int next : reverseGraph[node]) {
      if (!visited[next]) {
        reverseDfs(next, scc);
      }
    }
  }
}
