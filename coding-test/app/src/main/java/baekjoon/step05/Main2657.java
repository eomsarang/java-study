package baekjoon.step05;

import java.util.Scanner;

public class Main2657 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int T = sc.nextInt();

    for (int t = 0; t < T; t++) {
      int R = sc.nextInt();
      String S = sc.next();

      StringBuilder result = new StringBuilder();

      for (int i = 0; i < S.length(); i++) {
        char ch = S.charAt(i);
        for (int j = 0; j < R; j++) {
          result.append(ch);
        }
      }

      System.out.println(result);
    }
  }
}

