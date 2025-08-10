package baekjoon.step05;

import java.util.Scanner;

public class Main1152 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String str = sc.nextLine().trim();

    if (str.isEmpty()) {
      System.out.println(0);
    } else {
      String[] words = str.split(" ");
      System.out.println(words.length);
    }
  }
}
