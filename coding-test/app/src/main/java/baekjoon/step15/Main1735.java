package baekjoon.step15;

import java.util.Scanner;

public class Main1735 {

  public static int gcd(int a, int b) {
    while (b != 0) {
      int temp = a % b;
      a = b;
      b = temp;
    }
    return a;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();
    int d = sc.nextInt();

    int numerator = a * d + c * b;
    int denominator = b * d;

    int g = gcd(numerator, denominator);
    numerator /= g;
    denominator /= g;

    System.out.println(numerator + " " + denominator);
  }
}
