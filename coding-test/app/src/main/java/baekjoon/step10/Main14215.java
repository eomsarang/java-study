package baekjoon.step10;

import java.util.Arrays;
import java.util.Scanner;

public class Main14215 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int[] arr = new int[3];
    arr[0] = sc.nextInt();
    arr[1] = sc.nextInt();
    arr[2] = sc.nextInt();

    Arrays.sort(arr);
    int a = arr[0], b = arr[1], c = arr[2];

    if (c < a + b) {
      System.out.println(a + b + c);
    } else {
      System.out.println((a + b) * 2 - 1);
    }

    sc.close();
  }
}
