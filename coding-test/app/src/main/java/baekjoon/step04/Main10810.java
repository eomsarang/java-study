package baekjoon.step04;

import java.util.Scanner;

public class Main10810 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();

    int[] arr = new int[n];

    for (int x = 0; x < m; x++) {
      int i = sc.nextInt();
      int j = sc.nextInt();
      int k = sc.nextInt();

      for (int y = i; y < j + 1; y++) {
        y = arr[i];
      }
    }


  }
}
