package baekjoon.step05;

import java.util.Scanner;

public class Main9086 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int T = sc.nextInt();
    sc.nextLine();

    for (int i = 0; i < T; i++) {
      String str = sc.nextLine();
      char first = str.charAt(0);
      char last = str.charAt(str.length() - 1);
      System.out.println("" + first + last);
    }
  }
}
