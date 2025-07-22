package baekjoon.step01;

import java.util.Scanner;

public class Main11382 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // 조건에서 1조보다 작은지 비교하므로 8바이트 정수인 long 타입을 사용해서 입력을 받아야 한다
    long a = sc.nextLong();
    long b = sc.nextLong();
    long c = sc.nextLong();

    if (1 <= a && c <= 1e12) {
      long result = a + b + c;
      System.out.print(result);
    }
    sc.close();
  }
}
