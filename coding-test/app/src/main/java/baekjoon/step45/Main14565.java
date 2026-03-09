package baekjoon.step45;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14565 {

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
    StringTokenizer st = new StringTokenizer(br.readLine());

    long N = Long.parseLong(st.nextToken());
    long A = Long.parseLong(st.nextToken());

    long add = N - A;

    long[] r = egcd(A, N);

    long mul;

    if (r[0] != 1) {
      mul = -1;
    } else {
      mul = r[1] % N;
      if (mul < 0) {
        mul += N;
      }
    }

    System.out.println(add + " " + mul);
  }
}
