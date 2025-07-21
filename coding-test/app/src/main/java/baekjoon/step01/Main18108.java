package baekjoon.step01;

import java.util.Scanner;

public class Main18108 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int y = scanner.nextInt();
    int ad = y - 543;
    if (1000 <= y && y <= 3000) {
      System.out.print(ad);
    }
  }
}
