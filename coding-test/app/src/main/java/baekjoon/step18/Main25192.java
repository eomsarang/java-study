package baekjoon.step18;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main25192 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    sc.nextLine();

    Set<String> set = new HashSet<>();
    int count = 0;

    for (int i = 0; i < N; i++) {
      String s = sc.nextLine();

      if (s.equals("ENTER")) {
        set.clear();
      } else {
        if (!set.contains(s)) {
          set.add(s);
          count++;
        }
      }
    }

    System.out.println(count);
  }
}
