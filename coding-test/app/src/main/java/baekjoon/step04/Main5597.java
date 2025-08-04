package baekjoon.step04;

import java.util.Scanner;

public class Main5597 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] studentarr = new int[n];
    int[] studentcheck = new int[n];

    for (int i = 0; i < n; i++) {
      studentarr[i] = i + 1;
    }

    for (int i = 0; i < n; i++) {
      int studentno = sc.nextInt();

      studentcheck[i] = studentno;
    }

    for (int val : studentcheck) {

    }
  }
}
