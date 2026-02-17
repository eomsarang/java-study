package baekjoon.step41;

import java.util.Scanner;

public class Main19554 {

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);

    long N = sc.nextLong();

    long lo = 1;
    long hi = N;

    while (lo <= hi) {
      long mid = (lo + hi) / 2;

      System.out.println("? " + mid);
      System.out.flush();

      int res = sc.nextInt();

      if (res == 0) {
        System.out.println("= " + mid);
        System.out.flush();
        return;
      } else if (res == -1) {
        lo = mid + 1;
      } else {
        hi = mid - 1;
      }
    }
  }
}
