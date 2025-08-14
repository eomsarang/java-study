package baekjoon.step06;

import java.util.Scanner;

public class Main1316 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int count = 0;

    for (int i = 0; i < N; i++) {
      String word = sc.next();
      if (isGroupWord(word)) {
        count++;
      }
    }

    System.out.println(count);
  }

  public static boolean isGroupWord(String word) {
    boolean[] visited = new boolean[26];
    char prev = 0;

    for (int i = 0; i < word.length(); i++) {
      char now = word.charAt(i);

      if (now != prev) {
        if (visited[now - 'a']) {
          return false;
        }
        visited[now - 'a'] = true;
      }
      prev = now;
    }
    return true;
  }
}
