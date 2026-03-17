package baekjoon.step47;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main3584 {

  static int N;
  static int[] parent;
  static int[] depth;
  static ArrayList<Integer>[] tree;

  static void dfs(int node, int d) {
    depth[node] = d;

    for (int next : tree[node]) {
      dfs(next, d + 1);
    }
  }

  static int lca(int a, int b) {

    while (depth[a] > depth[b]) {
      a = parent[a];
    }
    while (depth[b] > depth[a]) {
      b = parent[b];
    }

    while (a != b) {
      a = parent[a];
      b = parent[b];
    }

    return a;
  }

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());

    while (T-- > 0) {

      N = Integer.parseInt(br.readLine());

      parent = new int[N + 1];
      depth = new int[N + 1];
      tree = new ArrayList[N + 1];

      for (int i = 1; i <= N; i++) {
        tree[i] = new ArrayList<>();
      }

      for (int i = 0; i < N - 1; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        parent[B] = A;
        tree[A].add(B);
      }

      int root = 0;
      for (int i = 1; i <= N; i++) {
        if (parent[i] == 0) {
          root = i;
          break;
        }
      }

      dfs(root, 0);

      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      sb.append(lca(a, b)).append('\n');
    }

    System.out.print(sb);
  }
}
