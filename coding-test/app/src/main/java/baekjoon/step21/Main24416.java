package baekjoon.step21;

import java.util.Scanner;

public class Main24416 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.close();

    int[] fib = new int[n + 1];
    fib[1] = 1;
    fib[2] = 1;
    for (int i = 3; i <= n; i++) {
      fib[i] = fib[i - 1] + fib[i - 2];
    }

    int code1 = fib[n];
    int code2 = n - 2;

    System.out.println(code1 + " " + code2);
  }
}
