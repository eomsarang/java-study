package baekjoon.step12;

import java.util.Scanner;

public class Main2231 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int result = 0;

    int length = String.valueOf(N).length();
    int start = N - 9 * length;
    if (start < 1) {
      start = 1;
    }

    for (int i = start; i < N; i++) {
      int sum = i;
      int temp = i;

      while (temp > 0) {
        sum += temp % 10;
        temp /= 10;
      }

      if (sum == N) {
        result = i;
        break;
      }
    }

    System.out.println(result);
  }
}
