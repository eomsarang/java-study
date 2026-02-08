package baekjoon.step39;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17386 {

  static long ccw(long ax, long ay, long bx, long by, long cx, long cy) {
    return (bx - ax) * (cy - ay) - (by - ay) * (cx - ax);
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
    } else {
      System.out.println(0);
    }
  }
}
