package baekjoon.step40;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main1086 {

  static int N, K;
  static String[] arr;
  static int[] valueMod;
  static int[] len;
  static int[] pow10Mod;
  static long[][] dp;

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    arr = new String[N];

    for (int i = 0; i < N; i++) {
      arr[i] = br.readLine();
    }

    K = Integer.parseInt(br.readLine());

    valueMod = new int[N];
    len = new int[N];

    for (int i = 0; i < N; i++) {
      int mod = 0;
      for (char c : arr[i].toCharArray()) {
        mod = (mod * 10 + (c - '0')) % K;
      }
      valueMod[i] = mod;
      len[i] = arr[i].length();
    }

    pow10Mod = new int[51];
    pow10Mod[0] = 1 % K;
    for (int i = 1; i <= 50; i++) {
      pow10Mod[i] = (pow10Mod[i - 1] * 10) % K;
    }

    int size = 1 << N;
    dp = new long[size][K];
    dp[0][0] = 1;

    for (int mask = 0; mask < size; mask++) {
      for (int r = 0; r < K; r++) {
        if (dp[mask][r] == 0) {
          continue;
        }

        for (int i = 0; i < N; i++) {
          if ((mask & (1 << i)) == 0) {
            int nextMask = mask | (1 << i);
            int nextR = (r * pow10Mod[len[i]] + valueMod[i]) % K;
            dp[nextMask][nextR] += dp[mask][r];
          }
        }
      }
    }

    long numerator = dp[size - 1][0];

    // 분모 = N!
    long denominator = 1;
    for (int i = 2; i <= N; i++) {
      denominator *= i;
    }

    if (numerator == 0) {
      System.out.println("0/1");
      return;
    }

    long gcd = gcd(numerator, denominator);
    System.out.println((numerator / gcd) + "/" + (denominator / gcd));
  }

  static long gcd(long a, long b) {
    while (b != 0) {
      long tmp = a % b;
      a = b;
      b = tmp;
    }
    return a;
  }
}
