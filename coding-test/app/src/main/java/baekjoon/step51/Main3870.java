package baekjoon.step51;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main3870 {

  static class Point implements Comparable<Point> {

    long x, y;

    Point(long x, long y) {
      this.x = x;
      this.y = y;
    }

    public int compareTo(Point o) {
      if (this.x == o.x) {
        return Long.compare(this.y, o.y);
      }
      return Long.compare(this.x, o.x);
    }
  }

  static long ccw(Point a, Point b, Point c) {
    return (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
  }

  static List<Point> hull(Point[] p) {
    Arrays.sort(p);
    List<Point> h = new ArrayList<>();

    for (Point pt : p) {
      while (h.size() >= 2 &&
          ccw(h.get(h.size() - 2), h.get(h.size() - 1), pt) <= 0) {
        h.removeLast();
      }
      h.add(pt);
    }

    int t = h.size();
    for (int i = p.length - 2; i >= 0; i--) {
      Point pt = p[i];
      while (h.size() > t &&
          ccw(h.get(h.size() - 2), h.get(h.size() - 1), pt) <= 0) {
        h.removeLast();
      }
      h.add(pt);
    }

    h.removeLast();
    return h;
  }

  static boolean intersect(Point a, Point b, Point c, Point d) {
    long ab = ccw(a, b, c) * ccw(a, b, d);
    long cd = ccw(c, d, a) * ccw(c, d, b);

    if (ab == 0 && cd == 0) {
      return Math.max(a.x, b.x) >= Math.min(c.x, d.x) &&
          Math.max(c.x, d.x) >= Math.min(a.x, b.x) &&
          Math.max(a.y, b.y) >= Math.min(c.y, d.y) &&
          Math.max(c.y, d.y) >= Math.min(a.y, b.y);
    }
    return ab <= 0 && cd <= 0;
  }

  static boolean inside(List<Point> h, Point p) {
    int n = h.size();
    for (int i = 0; i < n; i++) {
      if (ccw(h.get(i), h.get((i + 1) % n), p) <= 0) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());

    while (T-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());

      Point[] black = new Point[n];
      Point[] white = new Point[m];

      for (int i = 0; i < n; i++) {
        st = new StringTokenizer(br.readLine());
        black[i] = new Point(
            Long.parseLong(st.nextToken()),
            Long.parseLong(st.nextToken()));
      }

      for (int i = 0; i < m; i++) {
        st = new StringTokenizer(br.readLine());
        white[i] = new Point(
            Long.parseLong(st.nextToken()),
            Long.parseLong(st.nextToken()));
      }

      List<Point> bh = hull(black);
      List<Point> wh = hull(white);

      boolean ok = true;

      for (int i = 0; i < bh.size(); i++) {
        for (int j = 0; j < wh.size(); j++) {
          if (intersect(
              bh.get(i), bh.get((i + 1) % bh.size()),
              wh.get(j), wh.get((j + 1) % wh.size())
          )) {
            ok = false;
          }
        }
      }

      if (ok && inside(bh, wh.get(0))) {
        ok = false;
      }
      if (ok && inside(wh, bh.get(0))) {
        ok = false;
      }

      sb.append(ok ? "YES\n" : "NO\n");
    }

    System.out.print(sb);
  }
}