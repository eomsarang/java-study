package baekjoon.step52;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1395 {

  static int N, M;
  static int[] seg, lazy;

  static void propagate(int node, int l, int r) {
    if (lazy[node] == 1) {
      seg[node] = (r - l + 1) - seg[node];

      if (l != r) {
        lazy[node * 2] ^= 1;
        lazy[node * 2 + 1] ^= 1;
      }

      lazy[node] = 0;
    }
  }

  static void update(int node, int l, int r, int ql, int qr) {
    propagate(node, l, r);

    if (r < ql || qr < l) {
      return;
    }

    if (ql <= l && r <= qr) {
      lazy[node] ^= 1;
      propagate(node, l, r);
      return;
    }

    int mid = (l + r) / 2;
    update(node * 2, l, mid, ql, qr);
    update(node * 2 + 1, mid + 1, r, ql, qr);

    seg[node] = seg[node * 2] + seg[node * 2 + 1];
  }

  static int query(int node, int l, int r, int ql, int qr) {
    propagate(node, l, r);

    if (r < ql || qr < l) {
      return 0;
    }

    if (ql <= l && r <= qr) {
      return seg[node];
    }

    int mid = (l + r) / 2;
    return query(node * 2, l, mid, ql, qr)
        + query(node * 2 + 1, mid + 1, r, ql, qr);
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    seg = new int[4 * N];
    lazy = new int[4 * N];

    StringBuilder sb = new StringBuilder();

    while (M-- > 0) {
      st = new StringTokenizer(br.readLine());
      int op = Integer.parseInt(st.nextToken());
      int l = Integer.parseInt(st.nextToken());
      int r = Integer.parseInt(st.nextToken());

      if (op == 0) {
        update(1, 1, N, l, r);
      } else {
        sb.append(query(1, 1, N, l, r)).append("\n");
      }
    }

    System.out.print(sb);
  }
}