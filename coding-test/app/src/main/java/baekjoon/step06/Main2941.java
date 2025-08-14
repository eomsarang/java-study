package baekjoon.step06;
import java.util.Scanner;

public class Main2941 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String word = sc.next();

    String[] croatia = {"dz=", "c=", "c-", "d-", "lj", "nj", "s=", "z="};

    for (String alpha : croatia) {
      word = word.replace(alpha, "*");
    }

    System.out.println(word.length());
  }
}
