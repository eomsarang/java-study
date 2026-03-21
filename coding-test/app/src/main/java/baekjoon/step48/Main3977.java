package baekjoon.step48;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main3977 {

  static int N, M;
  static ArrayList<Integer>[] graph, reverse;
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

      graph = new ArrayList[N];
      reverse = new ArrayList[N];
      for (int i = 0; i < N; i++) {
        graph[i] = new ArrayList<>();
        reverse[i] = new ArrayList<>();
      }

      for (int i = 0; i < M; i++) {
        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        graph[A].add(B);
        reverse[B].add(A);
      }

      visited = new boolean[N];
      stack = new Stack<>();

      for (int i = 0; i < N; i++) {
        if (!visited[i]) {
          dfs1(i);
        }
      }

      visited = new boolean[N];
      sccId = new int[N];
      sccCount = 0;

      while (!stack.isEmpty()) {
        int cur = stack.pop();
        if (!visited[cur]) {
          dfs2(cur);
          sccCount++;
        }
      }

      int[] indegree = new int[sccCount];

      for (int i = 0; i < N; i++) {
        for (int next : graph[i]) {
          if (sccId[i] != sccId[next]) {
            indegree[sccId[next]]++;
          }
        }
      }

      int targetScc = -1;
      int count = 0;

      for (int i = 0; i < sccCount; i++) {
        if (indegree[i] == 0) {
          targetScc = i;
          count++;
        }
      }

      if (count != 1) {
        sb.append("Confused\n\n");
      } else {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < N; i++) {
          if (sccId[i] == targetScc) {
            result.add(i);
          }
        }
        Collections.sort(result);
        for (int x : result) {
          sb.append(x).append("\n");
        }
        sb.append("\n");
      }

      br.readLine();
    }

    System.out.print(sb);
  }

  static void dfs1(int x) {
    visited[x] = true;
    for (int next : graph[x]) {
      if (!visited[next]) {
        dfs1(next);
      }
    }
    stack.push(x);
  }

  static void dfs2(int x) {
    visited[x] = true;
    sccId[x] = sccCount;
    for (int next : reverse[x]) {
      if (!visited[next]) {
        dfs2(next);
      }
    }
  }
}
