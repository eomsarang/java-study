// 메서드: return, parameter
package study.lang.method;

public class Exam01 {

  public static void main(String[] args) {

    // 메서드 안에 있는 코드를 실행시키는 방법: 메서드 호출
    Exam01.m1();

    // 파라미터에 전달하는 값을 "argument"라 부른다.
    Exam01.m2("홍길동", 20);

    // 리턴타입이 있는 메서드를 호출할 때
    String str = m3();
    System.out.println(str);

    // 메서드가 리턴하는 값을 받지 않아도 된다.
    m3();

    // 아규먼트를 넘겨서 작업을 수행한 후 그 결과를 리턴 받기
    String msg = m4("홍길동", 20);
    System.out.println(msg);

    // 리턴 값은 받지 않아도 된다.
    m4("임꺽정", 30);
  }

  // method:
  // - 특정 기능을 수행하는 코드를 블록을 묶은 것

  // return: X
  // parameter: X
  static void m1() {
    System.out.println("m1()");
  }

  // return: X
  // parameter: O
  static void m2(String name, int age) {
    System.out.printf("m2(): %s, %d\n", name, age);
  }

  // return: O
  // parameter: X
  static String m3() {
    return "Hello!";
  }

  // return: O
  // parameter: O
  static String m4(String name, int age) {
    return String.format("%s(%d)님 환영합니다!\n", name, age);
  }
}
