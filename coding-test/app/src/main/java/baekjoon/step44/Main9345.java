package baekjoon.step44;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main9345 {

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

  static void update(int node, int start, int end, int idx) {

    if (start == end) {
      minTree[node] = arr[idx];
      maxTree[node] = arr[idx];
      return;
    }

    int mid = (start + end) / 2;

    if (idx <= mid) {
      update(node * 2, start, mid, idx);
    } else {
      update(node * 2 + 1, mid + 1, end, idx);
    }

    minTree[node] = Math.min(minTree[node * 2], minTree[node * 2 + 1]);
    maxTree[node] = Math.max(maxTree[node * 2], maxTree[node * 2 + 1]);
  }

  static int queryMin(int node, int start, int end, int l, int r) {

    if (r < start || end < l) {
      return Integer.MAX_VALUE;
    }

    if (l <= start && end <= r) {
      return minTree[node];
    }

    int mid = (start + end) / 2;

    return Math.min(
        queryMin(node * 2, start, mid, l, r),
        queryMin(node * 2 + 1, mid + 1, end, l, r)
    );
  }

  static int queryMax(int node, int start, int end, int l, int r) {

    if (r < start || end < l) {
      return Integer.MIN_VALUE;
    }

    if (l <= start && end <= r) {
      return maxTree[node];
    }

    int mid = (start + end) / 2;

    return Math.max(
        queryMax(node * 2, start, mid, l, r),
        queryMax(node * 2 + 1, mid + 1, end, l, r)
    );
  }

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());

    while (T-- > 0) {

      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int K = Integer.parseInt(st.nextToken());

      arr = new int[N];
      minTree = new int[4 * N];
      maxTree = new int[4 * N];

      for (int i = 0; i < N; i++) {
        arr[i] = i;
      }

      build(1, 0, N - 1);

      while (K-- > 0) {

        st = new StringTokenizer(br.readLine());

        int Q = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        if (Q == 0) {

          int temp = arr[A];
          arr[A] = arr[B];
          arr[B] = temp;

          update(1, 0, N - 1, A);
          update(1, 0, N - 1, B);

        } else {

          int min = queryMin(1, 0, N - 1, A, B);
          int max = queryMax(1, 0, N - 1, A, B);

          if (min == A && max == B) {
            sb.append("YES\n");
          } else {
            sb.append("NO\n");
          }
        }
      }
    }

    System.out.print(sb);
  }
}
