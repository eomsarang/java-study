package baekjoon.step24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11401 {

  static final long MOD = 1000000007L;
  static long[] factorial;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    factorial = new long[N + 1];
    factorial[0] = 1;

    // 1. 팩토리얼 미리 계산
    for (int i = 1; i <= N; i++) {
      factorial[i] = (factorial[i - 1] * i) % MOD;
    }

    // 2. 분모 부분 (K! * (N-K)!)의 역원을 계산
    long denom = (factorial[K] * factorial[N - K]) % MOD;

    long result = (factorial[N] * pow(denom, MOD - 2)) % MOD;

    System.out.println(result);
  }

  static long pow(long base, long exp) {
    if (exp == 0) {
      return 1;
    }
    long half = pow(base, exp / 2);
    long result = (half * half) % MOD;
    if (exp % 2 != 0) {
      result = (result * base) % MOD;
    }
    return result;
  }
}
