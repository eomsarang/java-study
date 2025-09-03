package baekjoon.step15;

import java.util.Scanner;

public class Main1934 {
  
  static int gcd(int a, int b) {
    while (b != 0) {
      int temp = a % b;
      a = b;
      b = temp;
    }
    return a;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int T = sc.nextInt();

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < T; i++) {
      int A = sc.nextInt();
      int B = sc.nextInt();

      int g = gcd(A, B);
      long lcm = (long) A * B / g;
      sb.append(lcm).append("\n");
    }

    System.out.print(sb);
  }
}
