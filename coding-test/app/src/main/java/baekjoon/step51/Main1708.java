package baekjoon.step51;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main1708 {

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

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    Point[] p = new Point[N];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      long x = Long.parseLong(st.nextToken());
      long y = Long.parseLong(st.nextToken());
      p[i] = new Point(x, y);
    }

    Arrays.sort(p);

    List<Point> lower = new ArrayList<>();
    for (Point pt : p) {
      while (lower.size() >= 2 &&
          ccw(lower.get(lower.size() - 2),
              lower.getLast(),
              pt) <= 0) {
        lower.removeLast();
      }
      lower.add(pt);
    }

    List<Point> upper = new ArrayList<>();
    for (int i = N - 1; i >= 0; i--) {
      Point pt = p[i];
      while (upper.size() >= 2 &&
          ccw(upper.get(upper.size() - 2),
              upper.getLast(),
              pt) <= 0) {
        upper.removeLast();
      }
      upper.add(pt);
    }

    lower.removeLast();
    upper.removeLast();

    System.out.println(lower.size() + upper.size());
  }
}