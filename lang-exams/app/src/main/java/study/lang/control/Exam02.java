// 조건문: else
package study.lang.control;

public class Exam02 {

  public static void main(String[] args) {
    int age = 20;

    // if 문을 이용하여 여러 조건을 검사할 수 있다.
    // 단, 모든 if 문의 조건을 검사한다.
    if (age >= 19)
      System.out.println("성년입니다.");
    if (age < 19)
      System.out.println("미성년입니다.");

    // if 문에 조건이 상호 배타적일 경우 else 문을 사용하는 것이 효율적이다.
    //    if (조건) 문장; else 문장;
    if (age >= 19)
      System.out.println("성년입니다.");
    else
      System.out.println("미성년입니다.");

    // if 문은 단독으로 사용할 수 있지만, else 문은 단독으로 사용할 수 없다.
//    else
//      System.out.println("컴파일 오류!");

    // 오류 예:
//    if (age >= 19)
//      System.out.println("성년입니다.");
//    System.out.println("-------------------"); // 이 문장이 if 문에 종속되지 않기 때문에 if 문은 끝난 상태이다.
//    else // 이미 위 문장에서 if 문이 끝났기 때문에 else 문은 단독문으로 간주되어 사용할 수 없다.
//      System.out.println("성년입니다.");
  }
}
