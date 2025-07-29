package baekjoon.step04;

//import java.util.Arrays;

import java.util.Scanner;

public class Main10807 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] arrV = new int[n];

    for (int i = 0; i < n; i++) {
      int v = sc.nextInt();
      arrV[i] += v;
    }

    int target = sc.nextInt();
    int count = 0;

    for (int num : arrV) {
      if (num == target) {
        count++;
      }
    }

//    long count = Arrays.stream(arrV) // 배열을 스트림으로 변환
    // stream: 자바 8부터 등장한 데이터 처리 추상화 도구로 필터링, 매핑, 집계 처리를 도와준다.
//        .filter(x -> x == target) // filter.(x -> 조건)
//        .count();   // long 반환
    // Method channing: 여러 메서드를 한줄로 호출하는 기법

    System.out.print(count);

  }
}
