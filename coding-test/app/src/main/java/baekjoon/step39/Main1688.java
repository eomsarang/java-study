package baekjoon.step39;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1688 {

  static class Point {

    long x, y;

    Point(long x, long y) {
      this.x = x;
      this.y = y;
    }
  }

  static long ccw(Point a, Point b, Point c) {
    return (b.x - a.x) * (c.y - a.y)
        - (b.y - a.y) * (c.x - a.x);
  }

  static boolean onSegment(Point a, Point b, Point p) {
    if (ccw(a, b, p) != 0) {
      return false;
    }

    return Math.min(a.x, b.x) <= p.x && p.x <= Math.max(a.x, b.x)
        && Math.min(a.y, b.y) <= p.y && p.y <= Math.max(a.y, b.y);
  }

  static boolean isInside(Point[] polygon, Point p) {
    int n = polygon.length;

    for (int i = 0; i < n; i++) {
      Point a = polygon[i];
      Point b = polygon[(i + 1) % n];
      if (onSegment(a, b, p)) {
        return true;
      }
    }

    int count = 0;

    for (int i = 0; i < n; i++) {
      Point a = polygon[i];
      Point b = polygon[(i + 1) % n];

      if ((a.y > p.y) != (b.y > p.y)) {
        double intersectX =
            (double) (b.x - a.x) * (p.y - a.y)
                / (double) (b.y - a.y) + a.x;

        if (p.x < intersectX) {
          count++;
        }
      }
    }

    return count % 2 == 1;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    Point[] polygon = new Point[N];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      long x = Long.parseLong(st.nextToken());
      long y = Long.parseLong(st.nextToken());
      polygon[i] = new Point(x, y);
    }

    for (int i = 0; i < 3; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      long x = Long.parseLong(st.nextToken());
      long y = Long.parseLong(st.nextToken());
      Point p = new Point(x, y);

      if (isInside(polygon, p)) {
        System.out.println(1);
      } else {
        System.out.println(0);
      }
    }
  }
}
