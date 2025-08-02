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
    int count = 0; // max의 인덱스 번째수를 초기화한다.

    for (int i = 1; i < 9; i++) {
      if (arr[i] > max) {
        max = arr[i];
        count = i; // max의 인덱스 번째수 갱신한다.
      }
    }

    System.out.println(max);
    System.out.println(count + 1); // 인덱스는 0부터 시작하므로 1을 더해준다.
    sc.close();

  }
}
