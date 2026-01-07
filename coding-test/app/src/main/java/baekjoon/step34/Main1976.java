package baekjoon.step34;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1976 {

  static int[] parent;

  static int find(int x) {
    if (parent[x] == x) {
      return x;
    }
    return parent[x] = find(parent[x]);
  }

  static void union(int a, int b) {
    int ra = find(a);
    int rb = find(b);
    if (ra != rb) {
      parent[rb] = ra;
    }
  }

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());

    parent = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      parent[i] = i;
    }

    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= N; j++) {
        int v = Integer.parseInt(st.nextToken());
        if (v == 1) {
          union(i, j);
        }
      }
    }

    st = new StringTokenizer(br.readLine());
    int first = Integer.parseInt(st.nextToken());
    int root = find(first);

    boolean possible = true;

    for (int i = 1; i < M; i++) {
      int nextCity = Integer.parseInt(st.nextToken());
      if (find(nextCity) != root) {
        possible = false;
        break;
      }
    }

    System.out.println(possible ? "YES" : "NO");
  }
}
