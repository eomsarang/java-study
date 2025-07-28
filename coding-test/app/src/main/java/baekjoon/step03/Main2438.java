package baekjoon.step03;

import java.util.Scanner;

public class Main2438 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    StringBuilder sb = new StringBuilder();

    if (1 <= n && n <= 100) {
      for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= i; j++) {
          sb.append("*");
        }
        sb.append("\n");
      }
    }
    System.out.print(sb);

    sc.close();
  }
}
