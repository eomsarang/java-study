package baekjoon.step08;

import java.util.Scanner;

public class Main2745 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String N = sc.next();
    int B = sc.nextInt();

    int result = 0;

    for (int i = 0; i < N.length(); i++) {
      char c = N.charAt(i);
      int value;

      if ('0' <= c && c <= '9') {
        value = c - '0';
      } else {
        value = c - 'A' + 10;
      }

      result = result * B + value;
    }

    System.out.println(result);
  }
}
