package baekjoon.step03;

import java.util.Scanner;

public class Main8393 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int result = 0;

    if (1 <= n && n <= 10000) {
      for (int i = 1; i < n + 1; i++) {
        result += i;
      }
    }
    System.out.print(result);
  }
}
