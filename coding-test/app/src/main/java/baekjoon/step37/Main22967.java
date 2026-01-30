package baekjoon.step37;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main22967 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    boolean[][] adj = new boolean[N + 1][N + 1];

    for (int i = 0; i < N - 1; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      adj[u][v] = true;
      adj[v][u] = true;
    }

    if (N == 2) {
      System.out.println(0);
      System.out.println(1);
      return;
    }

    int center = 1;
    List<int[]> added = new ArrayList<>();

    for (int i = 1; i <= N; i++) {
      if (i == center) {
        continue;
      }
      if (!adj[center][i]) {
        added.add(new int[]{center, i});
      }
    }

    int K = added.size();
    int R = 2;

    System.out.println(K);
    System.out.println(R);
    for (int[] e : added) {
      System.out.println(e[0] + " " + e[1]);
    }
  }
}
