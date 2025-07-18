// 메서드: Overloading
package study.lang.method;

public class Exam16 {

  public static void main(String[] args) {
    // 개발자가 더하기를 할 때 데이터 타입에 따라 호출할 메서드를 선택한다.
    int r1 = plusi(100, 200);
    float r2 = plusf(3.14f, 2.21f);
    double r3 = plusd(123.34, 345.67);
    // 이런 방식의 코딩일 때, 무엇이 문제인가?
    // - 더하기라는 같은 기능을 수행하는 메서드임에도 데이터 타입에 따라 호출하는 메서드 이름이 다르다.
    // - 호출하는 방법이 번거롭다.
    // 해결책?
    // - 같은 기능을 수행하는 메서드인 경우,
    //   파라미터의 형식이 다르더라도 같은 이름을 부여함으로써 일관성 있게 호출하게 도와주는 문법
    //   "오버로딩(Overloading)" 이다.
    // - 객체지향 프로그래밍 언어에 추가된 문법이다.

    // 함수를 호출할 때, 아규먼트 타입으로 호출할 함수를 자동 결정한다.
    r1 = plus(100, 200); // plus(int, int) 호출됨
    r2 = plus(3.14f, 2.24f); // plus(float, float) 호출됨
    r3 = plus(3.14, 2.24); // plus(double, double) 호출됨

    // 오버로딩 메서드의 대표적인 예:
    System.out.println(100); // println(int)가 호출됨
    System.out.println("Hello"); // println(String)가 호출됨
  }

  // Overloading 문법이 사용되기 전
  // - 모든 메서드의 이름을 다르게 짓는다.
  // - 문제점? 메서드 이름을 암기하기 번거롭다.
  static int plusi(int a, int b) {
    return a + b;
  }

  static float plusf(float a, float b) {
    return a + b;
  }

  static double plusd(double a, double b) {
    return a + b;
  }

  // 다음은 같은 이름을 가진 메서드이다.
  // 즉 오버로딩 문법이 적용된 경우!
  static int plus(int a, int b) {
    return a + b;
  }

  static float plus(float a, float b) {
    return a + b;
  }

  static double plus(double a, double b) {
    return a + b;
  }
}
