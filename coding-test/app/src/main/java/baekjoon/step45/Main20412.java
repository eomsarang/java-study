package baekjoon.step45;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main20412 {

  static long modPow(long a, long b, long mod) {
    long res = 1 % mod;
    a %= mod;

    while (b > 0) {
      if ((b & 1) == 1) {
        res = (res * a) % mod;
      }
      a = (a * a) % mod;
      b >>= 1;
    }
    return res;
  }

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    long m = Long.parseLong(st.nextToken());
    long seed = Long.parseLong(st.nextToken());
    long x1 = Long.parseLong(st.nextToken());
    long x2 = Long.parseLong(st.nextToken());

    long d = (x1 - seed) % m;
    if (d < 0) {
      d += m;
    }

    long inv = modPow(d, m - 2, m);

    long a = ((x2 - x1) % m + m) % m;
    a = (a * inv) % m;

    long c = (x1 - (a * seed) % m) % m;
    if (c < 0) {
      c += m;
    }

    System.out.println(a + " " + c);
  }
}
