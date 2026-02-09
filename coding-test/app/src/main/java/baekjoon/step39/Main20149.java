package baekjoon.step39;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main20149 {

  static long ccw(long ax, long ay, long bx, long by, long cx, long cy) {
    return (bx - ax) * (cy - ay) - (by - ay) * (cx - ax);
  }

  static boolean overlap(long a, long b, long c, long d) {
    return Math.max(a, b) >= Math.min(c, d) &&
        Math.max(c, d) >= Math.min(a, b);
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    long x1 = Long.parseLong(st.nextToken());
    long y1 = Long.parseLong(st.nextToken());
    long x2 = Long.parseLong(st.nextToken());
    long y2 = Long.parseLong(st.nextToken());

    st = new StringTokenizer(br.readLine());
    long x3 = Long.parseLong(st.nextToken());
    long y3 = Long.parseLong(st.nextToken());
    long x4 = Long.parseLong(st.nextToken());
    long y4 = Long.parseLong(st.nextToken());

    long ab_c = ccw(x1, y1, x2, y2, x3, y3);
    long ab_d = ccw(x1, y1, x2, y2, x4, y4);
    long cd_a = ccw(x3, y3, x4, y4, x1, y1);
    long cd_b = ccw(x3, y3, x4, y4, x2, y2);

    boolean intersect =
        ab_c * ab_d <= 0 &&
            cd_a * cd_b <= 0 &&
            overlap(x1, x2, x3, x4) &&
            overlap(y1, y2, y3, y4);

    if (!intersect) {
      System.out.println(0);
      return;
    }

    System.out.println(1);

    if (ab_c == 0 && ab_d == 0 && cd_a == 0 && cd_b == 0) {
      return;
    }

    if (ab_c == 0 && overlap(x1, x2, x3, x3) && overlap(y1, y2, y3, y3)) {
      System.out.println(x3 + " " + y3);
      return;
    }
    if (ab_d == 0 && overlap(x1, x2, x4, x4) && overlap(y1, y2, y4, y4)) {
      System.out.println(x4 + " " + y4);
      return;
    }
    if (cd_a == 0 && overlap(x3, x4, x1, x1) && overlap(y3, y4, y1, y1)) {
      System.out.println(x1 + " " + y1);
      return;
    }
    if (cd_b == 0 && overlap(x3, x4, x2, x2) && overlap(y3, y4, y2, y2)) {
      System.out.println(x2 + " " + y2);
      return;
    }

    // 일반적인 교차 → 교점 계산
    double A1 = y2 - y1;
    double B1 = x1 - x2;
    double C1 = A1 * x1 + B1 * y1;

    double A2 = y4 - y3;
    double B2 = x3 - x4;
    double C2 = A2 * x3 + B2 * y3;

    double det = A1 * B2 - A2 * B1;

    double x = (C1 * B2 - C2 * B1) / det;
    double y = (A1 * C2 - A2 * C1) / det;

    System.out.println(x + " " + y);
  }
}
