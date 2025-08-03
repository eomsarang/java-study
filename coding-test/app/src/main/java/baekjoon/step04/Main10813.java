package baekjoon.step04;

import java.util.Scanner;

public class Main10813 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();

    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = i;
    }

    for (int idx = 0; idx < m; idx++) {

      int i = sc.nextInt();
      int j = sc.nextInt();

      int indexi = arr[i];
      int indexj = arr[j];

      arr[i] = indexj;
      arr[j] = indexi;
    }

    for (int value : arr) {
      System.out.print(value + " ");
    }
    sc.close();

  }
}
