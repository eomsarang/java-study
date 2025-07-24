package baekjoon.step02;

import java.util.Scanner;

public class Main2480 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();

    if (a == b && b == c) { // 세 변수가 같은지 비교할 때는 &&를 사용하여 이 코드처럼 비교한다
      System.out.print(10000 + (a * 1000));
    } else if (a == b || a == c) { // 두 변수가 같은지 비교하는 경우 ||를 사용하여 같은 경우를 비교하면 된다
      System.out.print(1000 + (a * 100));
    } else if (b == c) {
      System.out.print(1000 + (b * 100));
    } else { // 위 조건을 제외한 나머지는 세 변수가 다른 경우 밖에 없으므로 else를 사용하여 코드를 간결히 한다
      int max = Math.max(a, Math.max(b, c));
      System.out.print(max * 100); // 최대값 구하기: Math.max(a, b)메서드는 둘 중 더 큰 파라미터를 반환
    }
    
  }
}
