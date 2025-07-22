package baekjoon.step02;

import java.util.Scanner;

public class Main2753 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int year = sc.nextInt();

    if (1 <= year && year <= 4000) {
      if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
        System.out.print(1);
      } else {
        System.out.print(0);
      }
    }

  }
}
