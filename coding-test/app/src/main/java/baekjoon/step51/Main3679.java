package baekjoon.step51;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main3679 {

  static class Point {

    int x, y, idx;

    Point(int x, int y, int idx) {
      this.x = x;
      this.y = y;
      this.idx = idx;
    }
  }

  static Point pivot;

  static long ccw(Point a, Point b, Point c) {
    return (long) (b.x - a.x) * (c.y - a.y)
        - (long) (b.y - a.y) * (c.x - a.x);
  }

  static long dist(Point a, Point b) {
    long dx = a.x - b.x;
    long dy = a.y - b.y;
    return dx * dx + dy * dy;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());

    while (T-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());

      Point[] p = new Point[n];

      for (int i = 0; i < n; i++) {
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        p[i] = new Point(x, y, i);
      }

      pivot = p[0];
      for (int i = 1; i < n; i++) {
        if (p[i].y < pivot.y ||
            (p[i].y == pivot.y && p[i].x < pivot.x)) {
          pivot = p[i];
        }
      }

      Arrays.sort(p, (a, b) -> {
        if (a == pivot) {
          return -1;
        }
        if (b == pivot) {
          return 1;
        }

        long c = ccw(pivot, a, b);
        if (c == 0) {
          return Long.compare(dist(pivot, a), dist(pivot, b));
        }
        return c > 0 ? -1 : 1;
      });

      int i = n - 1;
      while (i > 0 && ccw(pivot, p[i - 1], p[n - 1]) == 0) {
        i--;
      }

      reverse(p, i, n - 1);

      for (Point pt : p) {
        sb.append(pt.idx).append(" ");
      }
      sb.append("\n");
    }

    System.out.print(sb);
  }

  static void reverse(Point[] p, int l, int r) {
    while (l < r) {
      Point tmp = p[l];
      p[l] = p[r];
      p[r] = tmp;
      l++;
      r--;
    }
  }
}