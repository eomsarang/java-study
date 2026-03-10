package baekjoon.step45;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main13977 {

  static final int MAX = 4000000;
  static final long MOD = 1000000007;

  static long[] fact = new long[MAX + 1];
  static long[] invFact = new long[MAX + 1];

  static long modPow(long a, long b) {
    long res = 1;
    a %= MOD;

    while (b > 0) {
      if ((b & 1) == 1) {
        res = (res * a) % MOD;
      }
      a = (a * a) % MOD;
      b >>= 1;
    }

    return res;
  }

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    fact[0] = 1;

    for (int i = 1; i <= MAX; i++) {
      fact[i] = (fact[i - 1] * i) % MOD;
    }

    invFact[MAX] = modPow(fact[MAX], MOD - 2);

    for (int i = MAX - 1; i >= 0; i--) {
      invFact[i] = (invFact[i + 1] * (i + 1)) % MOD;
    }

    int M = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    while (M-- > 0) {

      st = new StringTokenizer(br.readLine());

      int N = Integer.parseInt(st.nextToken());
      int K = Integer.parseInt(st.nextToken());

      long ans = fact[N];
      ans = (ans * invFact[K]) % MOD;
      ans = (ans * invFact[N - K]) % MOD;

      sb.append(ans).append('\n');
    }

    System.out.print(sb);
  }
}
