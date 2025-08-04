package baekjoon.step04;

import java.util.Scanner;

public class Main10813 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();

    int[] arr = new int[n];

    // 주의! 인덱스는 시작자리 0부터 들어가야 하므로 반복문 시작은 0으로 하되 인덱스에 넣어주는 값을 맞추어 보정해야 한다.
    for (int i = 0; i < n; i++) {
      arr[i] = i + 1;
    }

    for (int idx = 0; idx < m; idx++) {

      int i = sc.nextInt();
      int j = sc.nextInt();

      int indexi = arr[i - 1];
      int indexj = arr[j - 1];

      arr[i - 1] = indexj;
      arr[j - 1] = indexi;
    }

    for (int value : arr) {
      System.out.print(value + " ");
    }
    sc.close();

  }
}
