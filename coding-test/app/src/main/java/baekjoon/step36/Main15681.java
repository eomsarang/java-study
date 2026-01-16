package baekjoon.step36;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main15681 {

  static int N, R, Q;
  static List<Integer>[] tree;
  static int[] subtree;

  static void dfs(int cur, int parent) {
    subtree[cur] = 1;

    for (int next : tree[cur]) {
      if (next == parent) {
        continue;
      }
      dfs(next, cur);
      subtree[cur] += subtree[next];
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    R = Integer.parseInt(st.nextToken());
    Q = Integer.parseInt(st.nextToken());

    tree = new ArrayList[N + 1];
    subtree = new int[N + 1];

    for (int i = 1; i <= N; i++) {
      tree[i] = new ArrayList<>();
    }

    for (int i = 0; i < N - 1; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      tree[u].add(v);
      tree[v].add(u);
    }

    dfs(R, -1);

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < Q; i++) {
      int u = Integer.parseInt(br.readLine());
      sb.append(subtree[u]).append('\n');
    }

    System.out.print(sb);
  }
}
