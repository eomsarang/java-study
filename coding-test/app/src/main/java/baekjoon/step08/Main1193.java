package baekjoon.step08;

import java.util.Scanner;

public class Main1193 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int X = sc.nextInt();

    int diagonal = 1;
    int count = 1;

    while (count < X) {
      diagonal++;
      count += diagonal;
    }

    int pos = count - X;
    int numerator, denominator;

    if (diagonal % 2 == 0) {
      numerator = diagonal - pos;
      denominator = 1 + pos;
    } else {
      numerator = 1 + pos;
      denominator = diagonal - pos;
    }

    System.out.println(numerator + "/" + denominator);
  }
}
