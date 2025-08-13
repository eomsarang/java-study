package baekjoon.step06;

import java.util.Scanner;

public class Main1157 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String word = sc.next().toUpperCase();

    int[] counts = new int[26];

    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      counts[ch - 'A']++;
    }

    int maxCount = -1;
    char maxChar = '?';
    boolean duplicate = false;

    for (int i = 0; i < 26; i++) {
      if (counts[i] > maxCount) {
        maxCount = counts[i];
        maxChar = (char) (i + 'A');
        duplicate = false;
      } else if (counts[i] == maxCount) {
        duplicate = true;
      }
    }

    System.out.println(duplicate ? "?" : maxChar);
  }
}
