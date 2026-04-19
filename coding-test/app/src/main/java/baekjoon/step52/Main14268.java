package baekjoon.step52;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main14268 {

  static int n, m;
  static ArrayList<Integer>[] tree;
  static int[] in, out;
  static int time = 1;

  static long[] seg, lazy;

  static void dfs(int cur) {
    in[cur] = time++;
    for (int nxt : tree[cur]) {
      dfs(nxt);
    }
    out[cur] = time - 1;
  }

  static void propagate(int node, int l, int r) {
    if (lazy[node] != 0) {
      seg[node] += (r - l + 1) * lazy[node];
      if (l != r) {
        lazy[node * 2] += lazy[node];
        lazy[node * 2 + 1] += lazy[node];
      }
      lazy[node] = 0;
    }
  }

  static void update(int node, int l, int r, int ql, int qr, long val) {
    propagate(node, l, r);

    if (r < ql || qr < l) {
      return;
    }

    if (ql <= l && r <= qr) {
      lazy[node] += val;
      propagate(node, l, r);
      return;
    }

    int mid = (l + r) / 2;
    update(node * 2, l, mid, ql, qr, val);
    update(node * 2 + 1, mid + 1, r, ql, qr, val);

    seg[node] = seg[node * 2] + seg[node * 2 + 1];
  }

  static long query(int node, int l, int r, int idx) {
    propagate(node, l, r);

    if (l == r) {
      return seg[node];
    }

    int mid = (l + r) / 2;
    if (idx <= mid) {
      return query(node * 2, l, mid, idx);
    } else {
      return query(node * 2 + 1, mid + 1, r, idx);
    }
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
    int root = 1;

    for (int i = 1; i <= n; i++) {
      int p = Integer.parseInt(st.nextToken());
      if (p != -1) {
        tree[p].add(i);
      }
    }

    in = new int[n + 1];
    out = new int[n + 1];

    dfs(root);

    seg = new long[4 * n];
    lazy = new long[4 * n];

    StringBuilder sb = new StringBuilder();

    while (m-- > 0) {
      st = new StringTokenizer(br.readLine());
      int type = Integer.parseInt(st.nextToken());

      if (type == 1) {
        int i = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        update(1, 1, n, in[i], out[i], w);

      } else {
        int i = Integer.parseInt(st.nextToken());
        sb.append(query(1, 1, n, in[i])).append("\n");
      }
    }

    System.out.print(sb);
  }
}