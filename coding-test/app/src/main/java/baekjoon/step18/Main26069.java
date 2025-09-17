package baekjoon.step18;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main26069 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    sc.nextLine();

    Set<String> dance = new HashSet<>();
    dance.add("ChongChong");

    for (int i = 0; i < N; i++) {
      String a = sc.next();
      String b = sc.next();

      if (dance.contains(a) || dance.contains(b)) {
        dance.add(a);
        dance.add(b);
      }
    }

    System.out.println(dance.size());
  }
}
