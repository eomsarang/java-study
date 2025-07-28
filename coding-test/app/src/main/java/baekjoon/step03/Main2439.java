package baekjoon.step03;

import java.util.Scanner;

public class Main2439 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    StringBuilder sb = new StringBuilder();

    // 왼쪽부터 별을 찍는 경우 공백의 개수(n - i) + 별 개수
    if (1 <= n && n <= 100) {
      for (int i = 1; i <= n; i++) {
        StringBuilder line = new StringBuilder(); // 한 라인씩 문자열에 공백과 별을 추가한다

        // 공백 찍기: 공백의 개수는 n - i 개 이다.
        for (int j = 1; j <= n - i; j++) {
          line.append(" ");
        }
        // 별 찍기: 별의 개수는 i개 이다.
        for (int j = 1; j <= i; j++) {
          line.append("*");
        }
        sb.append(line + "\n"); // immutable 객체에 라인과 줄바꿈을 추가한다
      }
    }
    System.out.print(sb);

    sc.close();
  }
}
