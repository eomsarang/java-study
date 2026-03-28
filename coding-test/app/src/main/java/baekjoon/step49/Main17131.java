package baekjoon.step49;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main17131 {

  static class Point {

    int x, y, idx;

    Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  static int[] tree;

  static void update(int i, int n) {
    while (i <= n) {
      tree[i]++;
      i += i & -i;
    }
  }

  static int query(int i) {
    int sum = 0;
    while (i > 0) {
      sum += tree[i];
      i -= i & -i;
    }
    return sum;
  }

  static final int MOD = 1_000_000_007;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    Point[] arr = new Point[N];
    int[] ys = new int[N];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      arr[i] = new Point(x, y);
      ys[i] = y;
    }

    Arrays.sort(ys);
    Map<Integer, Integer> map = new HashMap<>();
    int idx = 1;
    for (int y : ys) {
      if (!map.containsKey(y)) {
        map.put(y, idx++);
      }
    }

    for (Point p : arr) {
      p.y = map.get(p.y);
    }

    Arrays.sort(arr, (a, b) -> {
      if (a.x == b.x) {
        return a.y - b.y;
      }
      return a.x - b.x;
    });

    long[] left = new long[N];
    long[] right = new long[N];

    tree = new int[idx + 1];
    for (int i = 0; i < N; i++) {
      int y = arr[i].y;
      left[i] = query(idx) - query(y);
      update(y, idx);
    }

    tree = new int[idx + 1];
    for (int i = N - 1; i >= 0; i--) {
      int y = arr[i].y;
      right[i] = query(idx) - query(y);
      update(y, idx);
    }

    long answer = 0;
    for (int i = 0; i < N; i++) {
      answer = (answer + left[i] * right[i]) % MOD;
    }

    System.out.println(answer);
  }
}