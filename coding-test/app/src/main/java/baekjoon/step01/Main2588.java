package baekjoon.step01;

import java.util.Scanner;

public class Main2588 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String a = scanner.nextLine();
    String b = scanner.nextLine();

    char[] chars = b.toCharArray();
    int len = chars.length;

    int sum = 0;
    int pos = 1;

    for (int i = len - 1; i >= 0; i--) {
      int num = chars[i] - '0'; // char 문자를 숫자로 변환하는 방법
      int multiple = Integer.parseInt(a) * num;
      System.out.println(multiple);
      sum += multiple * (10 ^ pos);
      pos *= 10;
    }
    System.out.println(sum);
  }
}
