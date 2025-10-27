package baekjoon.step23;

import java.util.Scanner;

public class Main1541 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String expr = sc.nextLine();

    String[] minusSplit = expr.split("-");

    int result = 0;

    result += sumOfGroup(minusSplit[0]);

    for (int i = 1; i < minusSplit.length; i++) {
      result -= sumOfGroup(minusSplit[i]);
    }

    System.out.println(result);
  }

  static int sumOfGroup(String s) {
    String[] plusSplit = s.split("\\+"); // +는 정규식 특수문자라서 \\+로 해야 함
    int sum = 0;
    for (String num : plusSplit) {
      sum += Integer.parseInt(num);
    }
    return sum;
  }
}
