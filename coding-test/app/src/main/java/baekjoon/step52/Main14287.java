package baekjoon.step52;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main14287 {

  static int n, m;
  static ArrayList<Integer>[] tree;
  static int[] in, out;
  static int time = 1;

  static long[] bit;

  static void dfs(int cur) {
    in[cur] = time++;
    for (int nxt : tree[cur]) {
      dfs(nxt);
    }
    out[cur] = time - 1;
  }

  static void update(int i, long v) {
    while (i <= n) {
      bit[i] += v;
      i += i & -i;
    }
  }

  static long sum(int i) {
    long s = 0;
    while (i > 0) {
      s += bit[i];
      i -= i & -i;
    }
    return s;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    tree = new ArrayList[n + 1];
    for (int i = 1; i <= n; i++) {
      tree[i] = new ArrayList<>();
    }

    st = new StringTokenizer(br.readLine());

    for (int i = 1; i <= n; i++) {
      int p = Integer.parseInt(st.nextToken());
      if (p != -1) {
        tree[p].add(i);
      }
    }

    in = new int[n + 1];
    out = new int[n + 1];

    dfs(1);

    bit = new long[n + 1];

    StringBuilder sb = new StringBuilder();

    while (m-- > 0) {
      st = new StringTokenizer(br.readLine());
      int type = Integer.parseInt(st.nextToken());

      if (type == 1) {
        int i = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        update(in[i], w);

      } else {
        int i = Integer.parseInt(st.nextToken());

        long res = sum(out[i]) - sum(in[i] - 1);
        sb.append(res).append("\n");
      }
    }

    System.out.print(sb);
  }
}