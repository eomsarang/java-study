package baekjoon.step44;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2357 {

  static int N, M;
  static int[] arr;
  static int[] minTree;
  static int[] maxTree;

  static void build(int node, int start, int end) {
    if (start == end) {
      minTree[node] = arr[start];
      maxTree[node] = arr[start];
      return;
    }

    int mid = (start + end) / 2;
    build(node * 2, start, mid);
    build(node * 2 + 1, mid + 1, end);

    minTree[node] = Math.min(minTree[node * 2], minTree[node * 2 + 1]);
    maxTree[node] = Math.max(maxTree[node * 2], maxTree[node * 2 + 1]);
  }

  static int queryMin(int node, int start, int end, int left, int right) {
    if (right < start || end < left) {
      return Integer.MAX_VALUE;
    }

    if (left <= start && end <= right) {
      return minTree[node];
    }

    int mid = (start + end) / 2;

    return Math.min(
        queryMin(node * 2, start, mid, left, right),
        queryMin(node * 2 + 1, mid + 1, end, left, right)
    );
  }

  static int queryMax(int node, int start, int end, int left, int right) {
    if (right < start || end < left) {
      return 0;
    }

    if (left <= start && end <= right) {
      return maxTree[node];
    }

    int mid = (start + end) / 2;

    return Math.max(
        queryMax(node * 2, start, mid, left, right),
        queryMax(node * 2 + 1, mid + 1, end, left, right)
    );
  }

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st =
        new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    arr = new int[N + 1];
    minTree = new int[4 * N];
    maxTree = new int[4 * N];

    for (int i = 1; i <= N; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    build(1, 1, N);

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());

      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      int min = queryMin(1, 1, N, a, b);
      int max = queryMax(1, 1, N, a, b);

      sb.append(min).append(" ").append(max).append('\n');
    }

    System.out.print(sb);
  }
}
