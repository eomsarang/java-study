package baekjoon.step01;

import java.util.Scanner;

public class Main2588 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int a = sc.nextInt();
    sc.nextLine();

    String b = sc.nextLine();
    char[] arrB = b.toCharArray();
    int len = arrB.length;

    int sum = 0;
    int pos = 1;

    for (int i = len - 1; i >= 0; i--) {
      int num = arrB[i] - '0'; // char 문자를 숫자로 변환하는 방법
      int multiple = a * num;
      System.out.println(multiple);
      sum += multiple * pos;
      pos *= 10; // 주의! 거듭제곱의 경우 ^연산자 사용X --> 해당 연산자는 비트 연산을 의미
    }
    System.out.println(sum);
    sc.close();
  }
}
