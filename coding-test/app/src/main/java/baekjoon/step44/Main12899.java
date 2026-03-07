package baekjoon.step44;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main12899 {

  static int MAX = 2000000;
  static int[] tree = new int[4 * MAX + 5];

  static void update(int node, int start, int end, int idx, int diff) {

    if (idx < start || idx > end) {
      return;
    }

    tree[node] += diff;

    if (start == end) {
      return;
    }

    int mid = (start + end) / 2;

    update(node * 2, start, mid, idx, diff);
    update(node * 2 + 1, mid + 1, end, idx, diff);
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

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int N = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();

    while (N-- > 0) {

      st = new StringTokenizer(br.readLine());

      int T = Integer.parseInt(st.nextToken());
      int X = Integer.parseInt(st.nextToken());

      if (T == 1) {

        update(1, 1, MAX, X, 1);

      } else {

        int value = query(1, 1, MAX, X);
        sb.append(value).append('\n');

        update(1, 1, MAX, value, -1);
      }
    }

    System.out.print(sb);
  }
}
