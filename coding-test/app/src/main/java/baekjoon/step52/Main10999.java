package baekjoon.step52;
import java.io.*;
import java.util.*;

public class Main10999 {

  static int N, M, K;
  static long[] seg, lazy;

  static void propagate(int node, int l, int r) {
    if (lazy[node] != 0) {
      seg[node] += (r - l + 1) * lazy[node];

      if (l != r) {
        lazy[node*2] += lazy[node];
        lazy[node*2+1] += lazy[node];
      }

      lazy[node] = 0;
    }
  }

  static void update(int node, int l, int r, int ql, int qr, long val) {
    propagate(node, l, r);

    if (r < ql || qr < l) return;

    if (ql <= l && r <= qr) {
      lazy[node] += val;
      propagate(node, l, r);
      return;
    }

    int mid = (l + r) / 2;

    update(node*2, l, mid, ql, qr, val);
    update(node*2+1, mid+1, r, ql, qr, val);

    seg[node] = seg[node*2] + seg[node*2+1];
  }

  static long query(int node, int l, int r, int ql, int qr) {
    propagate(node, l, r);

    if (r < ql || qr < l) return 0;

    if (ql <= l && r <= qr) return seg[node];

    int mid = (l + r) / 2;

    return query(node*2, l, mid, ql, qr)
        + query(node*2+1, mid+1, r, ql, qr);
  }

  static void build(int node, int l, int r, long[] arr) {
    if (l == r) {
      seg[node] = arr[l];
      return;
    }

    int mid = (l + r) / 2;
    build(node*2, l, mid, arr);
    build(node*2+1, mid+1, r, arr);

    seg[node] = seg[node*2] + seg[node*2+1];
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    long[] arr = new long[N+1];

    for (int i = 1; i <= N; i++) {
      arr[i] = Long.parseLong(br.readLine());
    }

    seg = new long[4*N];
    lazy = new long[4*N];

    build(1, 1, N, arr);

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < M + K; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());

      if (a == 1) {
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        long d = Long.parseLong(st.nextToken());

        update(1, 1, N, b, c, d);

      } else {
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        sb.append(query(1, 1, N, b, c)).append("\n");
      }
    }

    System.out.print(sb);
  }
}}