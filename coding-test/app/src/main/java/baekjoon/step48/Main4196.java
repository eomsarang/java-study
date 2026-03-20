package baekjoon.step48;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main4196 {

  static int N, M;
  static ArrayList<Integer>[] graph, reverseGraph;
  static boolean[] visited;
  static Stack<Integer> stack;
  static int[] sccId;
  static int sccCount;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());

    while (T-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());

      graph = new ArrayList[N + 1];
      reverseGraph = new ArrayList[N + 1];

      for (int i = 1; i <= N; i++) {
        graph[i] = new ArrayList<>();
        reverseGraph[i] = new ArrayList<>();
      }

      for (int i = 0; i < M; i++) {
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        graph[x].add(y);
        reverseGraph[y].add(x);
      }

      visited = new boolean[N + 1];
      stack = new Stack<>();

      for (int i = 1; i <= N; i++) {
        if (!visited[i]) {
          dfs(i);
        }
      }

      visited = new boolean[N + 1];
      sccId = new int[N + 1];
      sccCount = 0;

      while (!stack.isEmpty()) {
        int node = stack.pop();
        if (!visited[node]) {
          sccCount++;
          reverseDfs(node);
        }
      }

      int[] indegree = new int[sccCount + 1];

      for (int i = 1; i <= N; i++) {
        for (int next : graph[i]) {
          if (sccId[i] != sccId[next]) {
            indegree[sccId[next]]++;
          }
        }
      }

      int answer = 0;
      for (int i = 1; i <= sccCount; i++) {
        if (indegree[i] == 0) {
          answer++;
        }
      }

      sb.append(answer).append("\n");
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

  static void reverseDfs(int node) {
    visited[node] = true;
    sccId[node] = sccCount;

    for (int next : reverseGraph[node]) {
      if (!visited[next]) {
        reverseDfs(next);
      }
    }
  }
}
