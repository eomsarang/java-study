package baekjoon.step15;

import java.util.Scanner;

public class Main13241 {

  static long gcd(long a, long b) {
    while (b != 0) {
      long temp = a % b;
      a = b;
      b = temp;
    }
    return a;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    long A = sc.nextLong();
    long B = sc.nextLong();

    long g = gcd(A, B);
    long lcm = (A / g) * B;

    System.out.println(lcm);
  }
}
