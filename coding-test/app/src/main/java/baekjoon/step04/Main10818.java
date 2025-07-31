package baekjoon.step04;

import java.util.Scanner;

public class Main10818 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    int[] arrN = new int[n];

    for (int i = 0; i < n; i++) {
      int num = sc.nextInt();
      arrN[i] += num;
    }


  }
}
