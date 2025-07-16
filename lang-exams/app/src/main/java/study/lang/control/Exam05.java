// 조건문: if ~ else 중첩 III
package study.lang.control;

public class Exam05 {

  public static void main(String[] args) {
    int age = 20;

    // 보통 코드의 가독성과 오류의 방지를 위해 중괄호를 사용한다.
    if (age < 8) {
      System.out.println("유아입니다.");
    } else if (age < 14) {
      System.out.println("어린이입니다.");
    } else if (age < 19) {
      System.out.println("청소년입니다.");
    } else if (age < 65) {
      System.out.println("성인입니다");
    } else {
      System.out.println("노인입니다.");
    }
  }
}
