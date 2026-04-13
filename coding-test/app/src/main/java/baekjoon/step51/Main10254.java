package baekjoon.step51;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main10254 {

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
    return (b.x - a.x) * (c.y - a.y)
        - (b.y - a.y) * (c.x - a.x);
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
      int N = Integer.parseInt(br.readLine());
      Point[] p = new Point[N];

      for (int i = 0; i < N; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        p[i] = new Point(
            Long.parseLong(st.nextToken()),
            Long.parseLong(st.nextToken())
        );
      }

      Arrays.sort(p);
      List<Point> hull = new ArrayList<>();

      for (Point pt : p) {
        while (hull.size() >= 2 &&
            ccw(hull.get(hull.size() - 2),
                hull.get(hull.size() - 1),
                pt) <= 0) {
          hull.removeLast();
        }
        hull.add(pt);
      }

      int t = hull.size();
      for (int i = N - 2; i >= 0; i--) {
        Point pt = p[i];
        while (hull.size() > t &&
            ccw(hull.get(hull.size() - 2),
                hull.getLast(),
                pt) <= 0) {
          hull.removeLast();
        }
        hull.add(pt);
      }

      hull.removeLast();

      int h = hull.size();

      int j = 1;
      long maxDist = 0;
      Point a = null, b = null;

      for (int i = 0; i < h; i++) {
        int ni = (i + 1) % h;

        while (true) {
          int nj = (j + 1) % h;

          long cur = Math.abs(ccw(hull.get(i), hull.get(ni), hull.get(nj)));
          long prev = Math.abs(ccw(hull.get(i), hull.get(ni), hull.get(j)));

          if (cur > prev) {
            j = nj;
          } else {
            break;
          }
        }

        long d = dist(hull.get(i), hull.get(j));
        if (d > maxDist) {
          maxDist = d;
          a = hull.get(i);
          b = hull.get(j);
        }
      }

      sb.append(Objects.requireNonNull(a).x).append(" ").append(a.y).append(" ")
          .append(b.x).append(" ").append(b.y).append("\n");
    }

    System.out.print(sb);
  }
}