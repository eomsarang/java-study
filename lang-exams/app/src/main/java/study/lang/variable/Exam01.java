// 변수 선언
// - 값을 저장할 메모리를 준비시키는 명령
// - static type binding 방식 사용
// - 즉 변수의 타입을 지정하면 종료할 때까지 변경할 수 없다.
package study.lang.variable;

public class Exam01 {
  public static void main(String[] args){
    // 변수선언 문법: 타입 변수명
    // 1) Primitive Type
    // - 정수 값을 저장할 변수 선언
    byte b = 100; // 1바이트(-128 ~ 127)
    short s = 32000; // 2바이트(-32768 ~ 32767)
    int i = 21_0000_0000; // 4바이트(약 -21억 ~ 21억)
    long l = 922_0000_0000_0000_0000L; // 8바이트(약 -922경 ~ 922경)

    // - 부동소수점 값을 저장할 변수
    float f = 3.14f; // 4바이트(유효자릿수 7자리)
    double d = 3.14; //8바이트(유효자릿수 16자리)

    // - 논리 값을 저장할 변수 선언
    boolean bool = true;

    // - 문자 코드를 저장할 변수 선언
    char c = 'A'; //2바이트(0 ~ 65535)

    // 2) Reference Type
    Object obj = new Object();
    String str = new String("Hello!");
  }
}
