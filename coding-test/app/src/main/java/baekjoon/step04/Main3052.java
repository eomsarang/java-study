package baekjoon.step04;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main3052 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int[] numberArr = new int[10];
    for (int i = 0; i < 10; i++) {
      int no = sc.nextInt(); // 지역변수
      numberArr[i] = no;
    }

    Set<Integer> numberSet = new HashSet<>();
    for (int i = 0; i < 10; i++) {
      int no = numberArr[i] % 42; // 지역변수: 메서드 실행시 Stack에 저장되었다가 종료시 사라진다.
      numberSet.add(no);
    }

    System.out.println(numberSet.size());
    sc.close();
  }
}
