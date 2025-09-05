package baekjoon.step15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main4948 {

  public static void main(String[] args) throws IOException {
    final int MAX = 246912;
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

    while (true) {
      int n = Integer.parseInt(br.readLine());
      if (n == 0) {
        break;
      }

      int count = 0;
      for (int i = n + 1; i <= 2 * n; i++) {
        if (isPrime[i]) {
          count++;
        }
      }
      sb.append(count).append("\n");
    }

    System.out.print(sb);
  }
}
