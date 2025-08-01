package baekjoon.step04;

import java.util.Scanner;

public class Main10818 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      int num = sc.nextInt();
      arr[i] += num;
    }

    // 먼저 값을 arr[0]으로 초기화한다.
    int max = arr[0];
    int min = arr[0];

    for (int i = 1; i < n; i++) { // 배열의 첫번째 인덱스부터 시작해서 값을 비교한다.
      if (arr[i] > max) { // max의 값보다 크면 max에 비교한 값이 대입된다.
        max = arr[i];
      }
      if (arr[i] < min) { // min의 값보다 작으면 min에 비교한 값이 대입된다.
        min = arr[i];
      }
    }

    System.out.printf("%d %d", min, max);
    sc.close();

  }
}
