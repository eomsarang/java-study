package baekjoon.step30;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main1644 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    boolean[] isPrime = new boolean[N + 1];
    Arrays.fill(isPrime, true);
    if (N >= 0) {
      isPrime[0] = false;
    }
    if (N >= 1) {
      isPrime[1] = false;
    }

    for (int i = 2; i * i <= N; i++) {
      if (isPrime[i]) {
        for (int j = i * i; j <= N; j += i) {
          isPrime[j] = false;
        }
      }
    }

    List<Integer> primes = new ArrayList<>();
    for (int i = 2; i <= N; i++) {
      if (isPrime[i]) {
        primes.add(i);
      }
    }

    int left = 0, right = 0;
    int sum = 0;
    int count = 0;

    while (true) {
      if (sum >= N) {
        if (sum == N) {
          count++;
        }
        sum -= primes.get(left++);
      } else {
        if (right == primes.size()) {
          break;
        }
        sum += primes.get(right++);
      }
    }

    System.out.println(count);
  }
}
