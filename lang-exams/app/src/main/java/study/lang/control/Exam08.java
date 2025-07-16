// 조건문: case 값
package study.lang.control;

public class Exam08 {

  public static void main(String[] args) {
    int a = 100;

    final int b = 200;
    int c = 300;
    // case는 리터럴 또는 final 변수만 올 수 있다.
    // 즉 상수 값만 가능하다.
    switch (a) {
      case 100: break;
      case b: break;
      case 40 + 50: break; // 리터럴의 계산 결과는 리터럴이므로 가능!
      case 10 + b: break; // 리터럴과 final 변수는 값이 바뀌지 않는 상수이다.
//      case c: break; // 컴파일 오류! c는 상수가 아니다.
//      case 10 + c: // 리터럴과 변수의 연산은 변수이다.
    }
  }
}
