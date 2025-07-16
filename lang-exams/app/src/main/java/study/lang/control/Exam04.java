// 조건문: if ~ else 중첩 II
package study.lang.control;

public class Exam04 {

  public static void main(String[] args) {
    int age = 20;

    // 코드의 가독성을 위해 들여쓰기를 다음과 같이 작성한다.
    // 조의! 자바는 else if 문법이 없다!
    if (age < 8)
      System.out.println("유아입니다.");
    else if (age < 14)
      System.out.println("어린이입니다.");
    else if (age < 19)
      System.out.println("청소년입니다.");
    else if (age < 65)
      System.out.println("성인입니다");
    else
      System.out.println("노인입니다.");

  }
}
