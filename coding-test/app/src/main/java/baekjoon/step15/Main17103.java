package baekjoon.step15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main17103 {

  public static void main(String[] args) throws IOException {
    final int MAX = 1000000;
    boolean[] isPrime = new boolean[MAX + 1];
    Arrays.fill(isPrime, true);

    isPrime[0] = false;
    isPrime[1] = false;

    for (int i = 2; i * i <= MAX; i++) {
      if (isPrime[i]) {
        for (int j = i * i; j <= MAX; j += i) {
          isPrime[j] = false;
        }
      }
    }

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());
    while (T-- > 0) {
      int N = Integer.parseInt(br.readLine());
      int count = 0;

      for (int i = 2; i <= N / 2; i++) {
        if (isPrime[i] && isPrime[N - i]) {
          count++;
        }
      }
      sb.append(count).append("\n");
    }

    System.out.print(sb);
  }
}
