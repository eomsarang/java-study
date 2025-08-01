package baekjoon.step04;

import java.util.Scanner;

public class Main2562 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int[] arr = new int[9];

    for (int i = 0; i < 9; i++) {
      int num = sc.nextInt();
      arr[i] += num;
    }

    int max = arr[0];
    int count = 0;

    for (int i = 1; i < 9; i++) {
      if (arr[i] > max) {
        max = arr[i];
      } else if (arr[i] != max) {
        count += 1;
      }
    }

    System.out.println(max);
    System.out.println(count);
    sc.close();

  }
}
