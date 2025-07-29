package baekjoon.step03;

import java.util.Scanner;

public class Main10951 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();

    int a, b;

    // Scanner의 hasNext() 메서드를 사용해서 사용자의 입력이 끝났을 때는 반복문을 종료한다.
    // 입력이 없을 때 종료한다고 해서 EOF(End Of File)처리 라고 한다.
    while (sc.hasNext()) {
      a = sc.nextInt();
      b = sc.nextInt();

      if (0 < a && b < 10) {
        sb.append(a + b + "\n");
      }
    }

    System.out.print(sb);
  }
}
