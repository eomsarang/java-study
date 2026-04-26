package baekjoon.step52;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main12844 {

  static int N, M;
  static int[] seg, lazy;

  static void propagate(int node, int l, int r) {
    if (lazy[node] != 0) {

      if ((r - l + 1) % 2 == 1) {
        seg[node] ^= lazy[node];
      }

      if (l != r) {
        lazy[node * 2] ^= lazy[node];
        lazy[node * 2 + 1] ^= lazy[node];
      }

      lazy[node] = 0;
    }
  }

  static void update(int node, int l, int r, int ql, int qr, int val) {
    propagate(node, l, r);

    if (r < ql || qr < l) {
      return;
    }

    if (ql <= l && r <= qr) {
      lazy[node] ^= val;
      propagate(node, l, r);
      return;
    }

    int mid = (l + r) / 2;
    update(node * 2, l, mid, ql, qr, val);
    update(node * 2 + 1, mid + 1, r, ql, qr, val);

    seg[node] = seg[node * 2] ^ seg[node * 2 + 1];
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
        ^ query(node * 2 + 1, mid + 1, r, ql, qr);
  }

  static void build(int node, int l, int r, int[] arr) {
    if (l == r) {
      seg[node] = arr[l];
      return;
    }

    int mid = (l + r) / 2;
    build(node * 2, l, mid, arr);
    build(node * 2 + 1, mid + 1, r, arr);

    seg[node] = seg[node * 2] ^ seg[node * 2 + 1];
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());

    int[] arr = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    seg = new int[4 * N];
    lazy = new int[4 * N];

    build(1, 0, N - 1, arr);

    M = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();

    while (M-- > 0) {
      st = new StringTokenizer(br.readLine());
      int t = Integer.parseInt(st.nextToken());

      if (t == 1) {
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        update(1, 0, N - 1, l, r, k);

      } else {
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        sb.append(query(1, 0, N - 1, l, r)).append("\n");
      }
    }

    System.out.print(sb);
  }
}