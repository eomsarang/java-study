// 메서드: Overloading II
package study.lang.method;

public class Exam17 {

  public static void main(String[] args) {
    plus(100, 200);
  }

  static int plus(int a, int b) {
    return a + b;
  }

  // 다음과 같이 타입이 달라야 한다.
  static float plus(int a, float b) {
    return a + b;
  }

  // 다음과 같이 순서가 달라야 한다.
  static float plus(float a, int b) {
    return a + b;
  }

  // 다음과 같이 파라미터 개수가 달라야 한다.
  static int plus(int a) {
    return a * 2;

    // 오류1: 파라미터명 다른 경우, 오버로딩 불가!
    // 왜? plus(100, 200) 할 때 구분할 수 없다.
//  static int plus(int b, int a) {
//    return a + b;
//  }

    // 오류2: 리턴 타입이 다른 경우 오버로딩 불가!
    // 왜? 호출한 쪽에서 리턴 값을 받지 않는 경우도 있다. 이럴 경우 어떤 메서드를 호출해야 할 지 결정할 수 없다.
//    static flaot plus(int a, int b) {
//      return (float) a + (float) b;
//    }

    // 메서드 시그니처(Signature)가 달라야만 오버로딩이 가능하다.
    // 단 리턴 타입만 다른 경우 같은 시그니처로 간주한다.
    // 시그니처?
    // - 메서드명, 파라미터 선언, 리턴 타입
    // - 즉 메서드 선언 형식
    // - C 언어에서는 "function prototype"이라 부른다.
  }
}
