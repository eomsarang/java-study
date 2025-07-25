package baekjoon.step03;

import java.util.Scanner;

public class Main10950 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    int[] result = new int[t]; // t번 만큼 한번에 입력 받기 위해서는 결과를 저장할 배열이 따로 준비한다

    for (int i = 0; i < t; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      if (0 < a && b < 10) {
        result[i] = a + b; // 배열의 0번째 부터 t 전까지 두 변수의 합을 배열에 저장한다
      }
    }

    for (int i = 0; i < t; i++) { // 배열의 0번째 부터 t 전까지 결과를 한 줄로 출력한다
      System.out.println(result[i]);
    }
    sc.close();

  }
}
