// 메서드: 스태틱 메서드(클래스 메서드)와 논스태틱 메서드(인스턴스 메서드)
package study.lang.method;

public class Exam02 {

  String name; // 인스턴스 필드

  public static void main(String[] args) {

    // 스태틱 메서드 호출
    //   클래스명.메서드명();
    // - 같은 클래스에서 호출한다면 클래스명 생략 가능!
    Exam02.m();
    m(); // 클래스명 생략 가능

    // 논스태틱(non-static) 메서드 호출
    // 인스턴스.메서드명();
//    Exam02.m2(); // 컴파일 오류!
//    m2(); // 컴파일 오류!

    Exam02 obj = new Exam02();
    Exam02 obj2 = new Exam02();

    obj.m2();
    System.out.println(obj.name);
    System.out.println(obj2.name);

    // 인스턴스 주소를 가지고 스태틱 메서드를 호출할 수 있다.
    obj.m(); // 컴파일은 허용해 주지만, 바람직한 호출은 아니다. m()에는 this 내장 변수가 없기 때문이다.
    // 클래스 이름으로 호출한 것으로 취급한다. 즉 문법적으로 컴파일 오류는 아니다!
  }

  // 클래스 메서드(static method)
  // - 클래스 이름으로 호출
  // - this 내장 변수가 없다.
  static void m() {
    System.out.println("Hello!");
  }

  // 인스턴스 메서드(non-static method)
  // - 인스턴스로 호출
  // - 인스턴스 주소를 담는 this라는 내장 변수가 있다.
  void m2() {
    this.name = "홍길동";
  }
}
