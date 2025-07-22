package baekjoon.step02;

import java.util.Scanner;

public class Main1330 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int a = sc.nextInt();
    int b = sc.nextInt();
    if ((-10000 <= a && a <= 10000) && (-10000 <= b && b <= 100000)) {
      if (a > b) {
        System.out.print(">");
      } else if (a < b) {
        System.out.print("<");
      } else if (a == b) {
        System.out.print("==");
      }
    }
    sc.close();
  }
}
