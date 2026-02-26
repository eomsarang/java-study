package baekjoon.step43;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main28121 {

  static class DSU {

    int[] parent;
    int[] size;
    int[] parity;
    boolean[] bad;

    DSU(int n) {
      parent = new int[n + 1];
      size = new int[n + 1];
      parity = new int[n + 1];
      bad = new boolean[n + 1];

      for (int i = 1; i <= n; i++) {
        parent[i] = i;
        size[i] = 1;
      }
    }

    int find(int x) {
      if (parent[x] == x) {
        return x;
      }
      int p = parent[x];
      parent[x] = find(parent[x]);
      parity[x] ^= parity[p];
      return parent[x];
    }
  }

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int Q = Integer.parseInt(st.nextToken());

    DSU dsu = new DSU(N);

    StringBuilder sb = new StringBuilder();
    long answer = 0;

    for (int qi = 0; qi < Q; qi++) {

      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      int ra = dsu.find(a);
      int pa = dsu.parity[a];

      int rb = dsu.find(b);
      int pb = dsu.parity[b];

      if (ra == rb) {
        if (pa == pb && !dsu.bad[ra]) {
          dsu.bad[ra] = true;
          answer += dsu.size[ra];
        }
      } else {
        if (dsu.size[ra] < dsu.size[rb]) {
          int tmp = ra;
          ra = rb;
          rb = tmp;
          tmp = pa;
          pa = pb;
          pb = tmp;
        }

        if (dsu.bad[ra]) {
          answer -= dsu.size[ra];
        }
        if (dsu.bad[rb]) {
          answer -= dsu.size[rb];
        }

        dsu.parent[rb] = ra;
        dsu.parity[rb] = pa ^ pb ^ 1;
        dsu.size[ra] += dsu.size[rb];
        dsu.bad[ra] |= dsu.bad[rb];

        if (dsu.bad[ra]) {
          answer += dsu.size[ra];
        }
      }

      sb.append(answer).append('\n');
    }

    System.out.print(sb);
  }
}
