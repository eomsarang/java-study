package baekjoon.step43;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3830 {

  static int[] parent;
  static long[] diff;

  static int find(int x) {
    if (parent[x] == x) {
      return x;
    }

    int p = parent[x];
    parent[x] = find(parent[x]);
    diff[x] += diff[p];
    return parent[x];
  }

  static void union(int a, int b, long w) {
    int ra = find(a);
    int rb = find(b);

    if (ra == rb) {
      return;
    }

    parent[rb] = ra;
    diff[rb] = w + diff[a] - diff[b];
  }

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    while (true) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());

      if (N == 0 && M == 0) {
        break;
      }

      parent = new int[N + 1];
      diff = new long[N + 1];

      for (int i = 1; i <= N; i++) {
        parent[i] = i;
      }

      for (int i = 0; i < M; i++) {

        st = new StringTokenizer(br.readLine());
        char cmd = st.nextToken().charAt(0);

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        if (cmd == '!') {
          long w = Long.parseLong(st.nextToken());
          union(a, b, w);
        } else {
          if (find(a) != find(b)) {
            sb.append("UNKNOWN\n");
          } else {
            sb.append(diff[b] - diff[a]).append('\n');
          }
        }
      }
    }

    System.out.print(sb);
  }
}
