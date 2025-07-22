package baekjoon.step02;

import java.util.Scanner;

public class Main14681 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int x = sc.nextInt();
    int y = sc.nextInt();

    if ((-1000 <= x && x <= 1000 && x != 0) && (-1000 <= y && y <= 1000 && y != 0)) {
      if (x > 0 && y > 0) {
        System.out.print(1);
      } else if (x < 0 && y > 0) {
        System.out.print(2);
      } else if (x < 0 && y < 0) {
        System.out.print(3);
      } else if (x > 0 && y < 0) {
        System.out.print(4);
      }
    }

    sc.close();
  }
}
