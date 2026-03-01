package baekjoon.step44;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2042 {

  static int N, M, K;
  static long[] tree;
  static long[] arr;

  static void update(int i, long diff) {
    while (i <= N) {
      tree[i] += diff;
      i += (i & -i);
    }
  }

  static long prefixSum(int i) {
    long sum = 0;
    while (i > 0) {
      sum += tree[i];
      i -= (i & -i);
    }
    return sum;
  }

  static long rangeSum(int l, int r) {
    return prefixSum(r) - prefixSum(l - 1);
  }

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    arr = new long[N + 1];
    tree = new long[N + 1];

    for (int i = 1; i <= N; i++) {
      arr[i] = Long.parseLong(br.readLine());
      update(i, arr[i]);
    }

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < M + K; i++) {
      st = new StringTokenizer(br.readLine());

      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      long c = Long.parseLong(st.nextToken());

      if (a == 1) {
        long diff = c - arr[b];
        arr[b] = c;
        update(b, diff);
      } else {
        sb.append(rangeSum(b, (int) c)).append('\n');
      }
    }

    System.out.print(sb);
  }
}
