package baekjoon.step42;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main17082 {

  static class Query {

    int l, r;

    Query(int l, int r) {
      this.l = l;
      this.r = r;
    }
  }

  static int N, M, Q;
  static int[] A;
  static int[] L, R;
  static int[] qi, qj;

  static int[] seg;

  static void build(int node, int l, int r) {
    if (l == r) {
      seg[node] = A[l];
      return;
    }
    int mid = (l + r) / 2;
    build(node * 2, l, mid);
    build(node * 2 + 1, mid + 1, r);
    seg[node] = Math.max(seg[node * 2], seg[node * 2 + 1]);
  }

  static int query(int node, int l, int r, int ql, int qr) {
    if (qr < l || r < ql) {
      return Integer.MIN_VALUE;
    }
    if (ql <= l && r <= qr) {
      return seg[node];
    }
    int mid = (l + r) / 2;
    return Math.max(
        query(node * 2, l, mid, ql, qr),
        query(node * 2 + 1, mid + 1, r, ql, qr)
    );
  }

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    Q = Integer.parseInt(st.nextToken());

    A = new int[N + 1];
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }

    L = new int[M];
    R = new int[M];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; i++) {
      L[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; i++) {
      R[i] = Integer.parseInt(st.nextToken());
    }

    qi = new int[Q];
    qj = new int[Q];

    for (int i = 0; i < Q; i++) {
      st = new StringTokenizer(br.readLine());
      qi[i] = Integer.parseInt(st.nextToken());
      qj[i] = Integer.parseInt(st.nextToken());
    }

    seg = new int[4 * (N + 5)];

    StringBuilder sb = new StringBuilder();

    for (int q = 0; q < Q; q++) {

      int tmp = A[qi[q]];
      A[qi[q]] = A[qj[q]];
      A[qj[q]] = tmp;

      build(1, 1, N);

      int ans = Integer.MIN_VALUE;

      int[] lcopy = L.clone();
      int[] rcopy = R.clone();
      Arrays.sort(lcopy);
      Arrays.sort(rcopy);

      for (int i = 0; i < M; i++) {
        if (lcopy[i] > rcopy[i]) {
          ans = 1000000000;
          break;
        }
        ans = Math.max(ans,
            query(1, 1, N, lcopy[i], rcopy[i]));
      }

      sb.append(ans).append('\n');
    }

    System.out.print(sb);
  }
}
