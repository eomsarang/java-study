package baekjoon.step04;

import java.util.Scanner;

public class Main10811 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();

    int[] numberArr = new int[n];
    for (int i = 0; i < n; i++) {
      numberArr[i] = i + 1;
    }

    for (int idx = 0; idx < m; idx++) {
      int i = sc.nextInt();
      int j = sc.nextInt();

      // i-1부터 j-1까지 양쪽에서 swap
      int left = i - 1;
      int right = j - 1;

      while (left < right) {
        int temp = numberArr[left]; // 임시변수에 값을 저장하여 맞바꾼다
        numberArr[left] = numberArr[right];
        numberArr[right] = temp;
        left++;
        right--;
      }
    }

    for (int num : numberArr) {
      System.out.print(num + " ");
    }

    sc.close();
  }
}
