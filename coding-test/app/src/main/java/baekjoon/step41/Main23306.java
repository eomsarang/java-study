package baekjoon.step41;

import java.util.Scanner;

public class Main23306 {

  public static void main(String[] args) throws Exception {

    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();

    System.out.println("? 1");
    System.out.flush();
    int s1 = sc.nextInt();

    System.out.println("? " + N);
    System.out.flush();
    int sN = sc.nextInt();

    int diff = sN - s1;

    int ans;
    if (diff > 0) {
      ans = 1;
    } else if (diff < 0) {
      ans = -1;
    } else {
      ans = 0;
    }

    System.out.println("! " + ans);
    System.out.flush();
  }
}
