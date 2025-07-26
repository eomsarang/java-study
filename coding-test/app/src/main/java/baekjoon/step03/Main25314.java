package baekjoon.step03;

import java.util.Scanner;

public class Main25314 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    // String은 immutable 객체지만 StringBuilder를 사용하여 객체를 생성하면 문자열 수정이 가능하다
    StringBuilder sb = new StringBuilder();

    if (4 <= n && n <= 1000 && (n % 4 == 0)) {
      for (int i = 0; i < n / 4; i++) {
        String str = "long";
        sb.append(str + " "); // append는 문자열 끝에 추가한다
      }
    }
    System.out.print(sb + "int");
  }
}
