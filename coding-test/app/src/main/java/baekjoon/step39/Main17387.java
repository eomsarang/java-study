package baekjoon.step39;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17387 {

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

    if (ab_c * ab_d < 0 && cd_a * cd_b < 0) {
      System.out.println(1);
      return;
    }

    if (ab_c == 0 && overlap(x1, x2, x3, x4) && overlap(y1, y2, y3, y4)) {
      System.out.println(1);
      return;
    }
    if (ab_d == 0 && overlap(x1, x2, x3, x4) && overlap(y1, y2, y3, y4)) {
      System.out.println(1);
      return;
    }
    if (cd_a == 0 && overlap(x3, x4, x1, x2) && overlap(y3, y4, y1, y2)) {
      System.out.println(1);
      return;
    }
    if (cd_b == 0 && overlap(x3, x4, x1, x2) && overlap(y3, y4, y1, y2)) {
      System.out.println(1);
      return;
    }

    System.out.println(0);
  }
}
