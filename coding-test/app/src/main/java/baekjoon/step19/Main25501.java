package baekjoon.step19;

import java.util.Scanner;

public class Main25501 {

  static int count;

  public static int recursion(String s, int l, int r) {
    count++;
    if (l >= r) {
      return 1;
    } else if (s.charAt(l) != s.charAt(r)) {
      return 0;
    } else {
      return recursion(s, l + 1, r - 1);
    }
  }

  public static int isPalindrome(String s) {
    return recursion(s, 0, s.length() - 1);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    sc.nextLine();

    for (int i = 0; i < T; i++) {
      String s = sc.nextLine();
      count = 0;
      int result = isPalindrome(s);
      System.out.println(result + " " + count);
    }
  }
}

