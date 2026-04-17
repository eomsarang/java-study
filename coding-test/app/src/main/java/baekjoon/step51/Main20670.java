package baekjoon.step51;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main20670 {

  static class Point {

    long x, y;

    Point(long x, long y) {
      this.x = x;
      this.y = y;
    }
  }

  static long ccw(Point a, Point b, Point c) {
    return (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
  }

  static boolean inside(Point[] poly, Point p) {
    int n = poly.length;

    if (ccw(poly[0], poly[1], p) <= 0) {
      return false;
    }
    if (ccw(poly[0], poly[n - 1], p) >= 0) {
      return false;
    }

    int l = 1, r = n - 1;

    while (l + 1 < r) {
      int mid = (l + r) / 2;
      if (ccw(poly[0], poly[mid], p) > 0) {
        l = mid;
      } else {
        r = mid;
      }
    }

    return ccw(poly[l], poly[r], p) > 0;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    Point[] A = new Point[N];
    Point[] B = new Point[M];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      A[i] = new Point(
          Long.parseLong(st.nextToken()),
          Long.parseLong(st.nextToken())
      );
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; i++) {
      B[i] = new Point(
          Long.parseLong(st.nextToken()),
          Long.parseLong(st.nextToken())
      );
    }

    st = new StringTokenizer(br.readLine());

    int invalid = 0;

    for (int i = 0; i < K; i++) {
      Point p = new Point(
          Long.parseLong(st.nextToken()),
          Long.parseLong(st.nextToken())
      );

      boolean inA = inside(A, p);
      boolean inB = inside(B, p);

      if (!(inA && !inB)) {
        invalid++;
      }
    }

    if (invalid == 0) {
      System.out.println("YES");
    } else {
      System.out.println(invalid);
    }
  }
}