package baekjoon.step06;

import java.util.Scanner;

public class Main10988 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String word = sc.next();

    boolean isPalindrome = true;
    int len = word.length();

    for (int i = 0; i < len / 2; i++) {
      if (word.charAt(i) != word.charAt(len - 1 - i)) {
        isPalindrome = false;
        break;
      }
    }

    System.out.println(isPalindrome ? 1 : 0);
  }
}
