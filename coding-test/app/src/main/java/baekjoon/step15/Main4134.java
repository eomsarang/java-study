package baekjoon.step15;

import java.util.Scanner;

public class Main4134 {

  public static boolean isPrime(long n) {
    if (n < 2) {
      return false;
    }
    if (n == 2) {
      return true;
    }
    if (n % 2 == 0) {
      return false;
    }
    long sqrt = (long) Math.sqrt(n);
    for (long i = 3; i <= sqrt; i += 2) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();

    while (T-- > 0) {
      long n = sc.nextLong();
      while (!isPrime(n)) {
        n++;
      }
      System.out.println(n);
    }
  }
}
