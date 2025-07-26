package baekjoon.step03;

import java.util.Scanner;

public class Main25304 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int x = sc.nextInt();
    int n = sc.nextInt();
    int[][] arr = new int[n][2]; // 길이가 2이고, n개의 행을 가진 배열을 만든다
    int result = 0;

    if (1 <= n && n <= 100) {
      for (int i = 0; i < n; i++) { // 배열이 n개의 행을 갖는데 i가 0부터 시작하므로 범위는 n 전까지 이다
        int a = sc.nextInt();
        int b = sc.nextInt();
        if ((1 <= a && a <= 1000000) && (1 <= b && b <= 10)) {
          arr[i][0] += a;
          arr[i][1] += b;
          result += a * b;
        }
      }
    }

    if (1 <= x && x <= 1000000000) {
      if (x == result) {
        System.out.print("Yes");
      } else if (x != result) {
        System.out.print("No");
      }
    }

  }
}
