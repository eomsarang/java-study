package baekjoon.step51;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main7420 {

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

  static double dist(Point a, Point b) {
    long dx = a.x - b.x;
    long dy = a.y - b.y;
    return Math.sqrt(dx * dx + dy * dy);
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int L = Integer.parseInt(st.nextToken());

    Point[] p = new Point[N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
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
              hull.getLast(),
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

    double perimeter = 0;
    int h = hull.size();

    for (int i = 0; i < h; i++) {
      Point a = hull.get(i);
      Point b = hull.get((i + 1) % h);
      perimeter += dist(a, b);
    }

    perimeter += 2 * Math.PI * L;

    System.out.println(Math.round(perimeter));
  }
}