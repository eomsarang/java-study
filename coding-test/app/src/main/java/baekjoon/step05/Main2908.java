package baekjoon.step05;

import java.util.Scanner;

public class Main2908 {

  public static int reverse(int num) {
    int rev = 0;
    while (num > 0) {
      rev = rev * 10 + (num % 10);
      num /= 10;
    }
    return rev;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int A = sc.nextInt();
    int B = sc.nextInt();

    int revA = reverse(A);
    int revB = reverse(B);

    System.out.println(Math.max(revA, revB));
  }
}
