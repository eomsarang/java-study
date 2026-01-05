package baekjoon.step34;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1717 {

  static int[] parent;

  static int find(int x) {
    if (parent[x] == x) {
      return x;
    }
    return parent[x] = find(parent[x]);
  }

  static void union(int a, int b) {
    int rootA = find(a);
    int rootB = find(b);
    if (rootA != rootB) {
      parent[rootB] = rootA;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    parent = new int[n + 1];
    for (int i = 0; i <= n; i++) {
      parent[i] = i;
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int op = Integer.parseInt(st.nextToken());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      if (op == 0) {
        union(a, b);
      } else {
        if (find(a) == find(b)) {
          sb.append("YES\n");
        } else {
          sb.append("NO\n");
        }
      }
    }

    System.out.print(sb);
  }
}
