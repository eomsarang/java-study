// 조건문: if ~ else 중첩
package study.lang.control;

public class Exam03 {

  public static void main(String[] args) {
    int age = 20;

    // if ~ else ~ 는 한 문장으로 간주된다.
    // 그래서 else 문 안에 있는 if ~ else ~ 문은 중괄호로 묶을 필요가 없다.
    if (age < 8)
      System.out.println("유아입니다.");
    else
      if (age < 14)
        System.out.println("어린이입니다.");
      else
        if (age < 19)
        System.out.println("청소년입니다.");
        else
          if (age < 65)
            System.out.println("성인입니다");
          else
            System.out.println("노인입니다.");

  }
}
