package baekjoon.step45;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3955 {

  static long[] egcd(long a, long b) {

    if (b == 0) {
      return new long[]{a, 1, 0};
    }

    long[] r = egcd(b, a % b);

    long g = r[0];
    long x = r[2];
    long y = r[1] - (a / b) * r[2];

    return new long[]{g, x, y};
  }

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int t = Integer.parseInt(br.readLine());

    while (t-- > 0) {

      StringTokenizer st = new StringTokenizer(br.readLine());
      long K = Long.parseLong(st.nextToken());
      long C = Long.parseLong(st.nextToken());

      long[] r = egcd(C, K);

      long g = r[0];
      long y = r[1];

      if (g != 1) {
        sb.append("IMPOSSIBLE\n");
        continue;
      }

      y %= K;
      if (y <= 0) {
        y += K;
      }

      if (y > 1_000_000_000L) {
        sb.append("IMPOSSIBLE\n");
      } else {
        sb.append(y).append('\n');
      }
    }

    System.out.print(sb);
  }
}
