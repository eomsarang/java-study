// 조건문
package study.lang.control;

public class Exam01 {

  public static void main(String[] args) {
    int age = 10;

    // 기본형식:
    //    if (boolean) 문장;
    if (age >= 19) System.out.println("성년입니다.");

    // 코드의 가독성을 높이기 위해 보통 다음 줄에 문장을 작성한다.
    if (age >= 19)
      System.out.println("성년입니다.");

    // 주의!
    if (age >= 19); // 실수로 if 문의 조건 뒤에 세미콜론을 적으면 빈 문장을 작성한 것으로 간주하고 if 문을 끝낸다.
      System.out.println("성년입니다."); // if 문 소속이 아니다.

    // 주의!
    // - 들여쓰기는 문장의 소속과 상관없다.
    if (age >= 19)
    System.out.println("성년입니다."); // if 문 소속이다.
    System.out.println("---------------------"); // if 문에 소속된 문장이 아니다.

    // 여러 문장을 한 단위로 다루고 싶다면 중괄호를 사용해야 한다.
    //    if (boolean) {문장1, 문장2, ...}
    if (age >= 19) {
      System.out.println("성년입니다2.");
      System.out.println("---------------------2"); // 들여쓰기는 문장의 소속과 상관없다.
    }
  }
}
