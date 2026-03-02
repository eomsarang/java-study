package baekjoon.step44;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11505 {

  static final long MOD = 1000000007L;

  static int N, M, K;
  static long[] tree;
  static long[] arr;


  static long build(int node, int start, int end) {
    if (start == end) {
      return tree[node] = arr[start];
    }

    int mid = (start + end) / 2;
    long left = build(node * 2, start, mid);
    long right = build(node * 2 + 1, mid + 1, end);

    return tree[node] = (left * right) % MOD;
  }

  static long update(int node, int start, int end, int idx, long value) {

    if (idx < start || idx > end) {
      return tree[node];
    }

    if (start == end) {
      return tree[node] = value;
    }

    int mid = (start + end) / 2;

    long left = update(node * 2, start, mid, idx, value);
    long right = update(node * 2 + 1, mid + 1, end, idx, value);

    return tree[node] = (left * right) % MOD;
  }

  static long query(int node, int start, int end, int left, int right) {

    if (right < start || end < left) {
      return 1;
    }

    if (left <= start && end <= right) {
      return tree[node];
    }

    int mid = (start + end) / 2;

    long l = query(node * 2, start, mid, left, right);
    long r = query(node * 2 + 1, mid + 1, end, left, right);

    return (l * r) % MOD;
  }

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st =
        new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    arr = new long[N + 1];
    tree = new long[4 * N];

    for (int i = 1; i <= N; i++) {
      arr[i] = Long.parseLong(br.readLine());
    }

    build(1, 1, N);

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < M + K; i++) {

      st = new StringTokenizer(br.readLine());

      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      long c = Long.parseLong(st.nextToken());

      if (a == 1) {
        update(1, 1, N, b, c);
      } else {
        sb.append(query(1, 1, N, b, (int) c))
            .append('\n');
      }
    }

    System.out.print(sb);
  }
}
