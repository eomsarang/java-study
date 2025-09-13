package baekjoon.step17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main11050 {

  static int factorial(int n) {
    if (n <= 1) {
      return 1;
    }
    return n * factorial(n - 1);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int N = Integer.parseInt(input[0]);
    int K = Integer.parseInt(input[1]);

    int result = factorial(N) / (factorial(K) * factorial(N - K));
    System.out.println(result);
  }
}
