package baekjoon.step44;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1168 {

  static int N, K;
  static int[] tree;

  static void build(int node, int start, int end) {
    if (start == end) {
      tree[node] = 1;
      return;
    }

    int mid = (start + end) / 2;

    build(node * 2, start, mid);
    build(node * 2 + 1, mid + 1, end);

    tree[node] = tree[node * 2] + tree[node * 2 + 1];
  }

  static int query(int node, int start, int end, int k) {

    if (start == end) {
      return start;
    }

    int mid = (start + end) / 2;

    if (tree[node * 2] >= k) {
      return query(node * 2, start, mid, k);
    } else {
      return query(node * 2 + 1, mid + 1, end, k - tree[node * 2]);
    }
  }

  static void update(int node, int start, int end, int idx) {

    if (idx < start || idx > end) {
      return;
    }

    tree[node]--;

    if (start == end) {
      return;
    }

    int mid = (start + end) / 2;

    update(node * 2, start, mid, idx);
    update(node * 2 + 1, mid + 1, end, idx);
  }

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    tree = new int[4 * N];
    build(1, 1, N);

    StringBuilder sb = new StringBuilder();
    sb.append("<");

    int pos = 0;

    for (int i = 0; i < N; i++) {

      int alive = N - i;
      pos = (pos + K - 1) % alive;

      int idx = query(1, 1, N, pos + 1);

      sb.append(idx);

      if (i != N - 1) {
        sb.append(", ");
      }

      update(1, 1, N, idx);
    }

    sb.append(">");

    System.out.println(sb);
  }
}
