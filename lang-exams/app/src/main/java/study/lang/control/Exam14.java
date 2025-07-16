// 반복문: for
package study.lang.control;

public class Exam14 {

  // 중첩된 반복문
  public static void main(String[] args) {

    // for (변수초기화; 조건; 증감문) 문장;
    for (int i = 0; i < 10; i++) {
      System.out.print(i + ",");
    }
    System.out.println();
//    System.out.println(i); // 컴파일 오류! i 변수는 for 문에 소속된 변수다.

    // 초기화 문장 생략 가능
    int i = 0;
    for (; i < 10; i++) {
      System.out.print(i + ",");
    }
    System.out.println();
    System.out.println(i);

    // 증감문 생략 가능
    i = 0;
    for (; i < 10;) {
      System.out.print(i + ",");
      i++;
    }
    System.out.println();

    // 조건 생략 가능
    i = 0;
    for (;;) {
      if (i >= 10) {
        break;
      }
      System.out.print(i + ",");
      i++;
    }
    System.out.println();
  }
}
