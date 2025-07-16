// 반복문: for II
package study.lang.control;

public class Exam15 {

  // 중첩된 반복문
  public static void main(String[] args) {

    // 여러 개의 변수를 초기화시킬 수 있다.
    for (int i = 0, j = 0; i < 10; i++, j = j + 2) {
      System.out.printf("%d -- %d\n", i, j);
    }
    System.out.println();

  }
}
