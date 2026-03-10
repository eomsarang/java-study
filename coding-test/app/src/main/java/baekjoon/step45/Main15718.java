package baekjoon.step45;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main15718 {

  static final int MOD = 100007;
  static long[] fact = new long[MOD];
  static long[] invFact = new long[MOD];

  static long pow(long a, long b) {
    long res = 1;
    a %= MOD;
    while (b > 0) {
      if ((b & 1) == 1) {
        res = res * a % MOD;
      }
      a = a * a % MOD;
      b >>= 1;
    }
    return res;
  }

  static void init() {
    fact[0] = 1;
    for (int i = 1; i < MOD; i++) {
      fact[i] = fact[i - 1] * i % MOD;
    }

    invFact[MOD - 1] = pow(fact[MOD - 1], MOD - 2);

    for (int i = MOD - 2; i >= 0; i--) {
      invFact[i] = invFact[i + 1] * (i + 1) % MOD;
    }
  }

  static long comb(long n, long r) {
    if (r > n) {
      return 0;
    }
    return fact[(int) n] * invFact[(int) r] % MOD * invFact[(int) (n - r)] % MOD;
  }

  static long lucas(long n, long r) {
    long res = 1;

    while (n > 0 || r > 0) {
      long ni = n % MOD;
      long ri = r % MOD;

      if (ri > ni) {
        return 0;
      }

      res = res * comb(ni, ri) % MOD;

      n /= MOD;
      r /= MOD;
    }

    return res;
  }

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    init();

    int T = Integer.parseInt(br.readLine());

    while (T-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      long N = Long.parseLong(st.nextToken());
      long M = Long.parseLong(st.nextToken());

      long n = N + M - 1;
      long r = M - 1;

      sb.append(lucas(n, r)).append("\n");
    }

    System.out.print(sb);
  }
}
