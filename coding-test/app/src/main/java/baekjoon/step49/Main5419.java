package baekjoon.step49;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main5419 {

  static class Point {

    int x, y;

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

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(br.readLine());

    while (T-- > 0) {
      int n = Integer.parseInt(br.readLine());
      Point[] arr = new Point[n];

      int[] ys = new int[n];

      for (int i = 0; i < n; i++) {
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
          return b.y - a.y;
        }
        return a.x - b.x;
      });

      tree = new int[idx + 1];

      long answer = 0;

      for (Point p : arr) {
        answer += query(idx) - query(p.y - 1);
        update(p.y, idx);
      }

      sb.append(answer).append("\n");
    }

    System.out.print(sb);
  }
}