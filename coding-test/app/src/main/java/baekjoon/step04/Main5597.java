package baekjoon.step04;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main5597 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    Set<Integer> checkArr = new HashSet<>(); // Set은 인터페이스 이므로 구현체 생성시 HashSet<> 사용
    for (int i = 1; i < 31; i++) {
      checkArr.add(i);
    }

    for (int i = 0; i < 28; i++) {
      int studentNo = sc.nextInt();
      checkArr.remove(studentNo); // 전체 출석집합 30명에서 에서 출석한 학생 28명의 출석번호를 제거한다.
    }

    for (int student : checkArr) { // 집합에 남아있는 학생 번호를 출력한다.
      System.out.println(student);
    }

    sc.close();
  }
}
