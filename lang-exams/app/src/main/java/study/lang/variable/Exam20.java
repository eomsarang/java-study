// 값 저장 - 다른 타입일 경우(명시적 형변환)
package study.lang.variable;

public class Exam20 {

  public static void main(String[] args) {
    byte b = 100;
    short s = 100;
    int i = 100;
    long l = 100L;
    char c = 'A';
    float f = 3.14f;
    double d = 3.14;
    boolean bool = true;

    float f2;
    f2 = b; // b 변수에 들어있는 값을 꺼내서 float 타입의 값으로 바꿔라.
    f2 = s;
    f2 = c;
    f2 = (float) i;
    f2 = (float) l;

    double d2;
    d2 = b;
    d2 = s;
    d2 = c;
    d2 = i;
    d2 = (double) l;
    // 정수 값을 부동소수점 변수에 저장할 때 특히 주의해야 한다.
    // - 유효자릿수를 초과하더라도 컴파일 오류가 발생하지 않기 때문이다.

    // 부동소수점 값을 정수 변수에 저장
    // - 명시적 형변환을 지정하면 컴파일 오류가 발생하지 않는다.
    l = (long) f; // f에 저장된 값을 꺼내서 소수점을 제외한 후 l 변수에 저장한다.
    l = (long) d; // d에 저장된 값을 꺼내서 소수점을 제외한 후 l 변수에 저장한다.

    // boolean 값은 오직 boolean 변수에만 저장 가능
    // - 명시적 형변환을 사용할 수 없다.
//    b = (byte) bool; // 컴파일 오류!
//    s = (byte) bool;
//    i = (byte) bool;
//    l = (byte) bool;
//    c = (byte) bool;
//    f = (byte) bool;
//    d = (byte) bool;

    // 문자열 변환은 명시적 형변환을 사용할 수 없다.
//    String s1 = (String) 100; // 컴파일 오류!
    String s2 = String.valueOf(100); // 메서드의 도움을 받아서 문자열로 바꾼다.

//    int i2 = (int)"100"; // 컴파일 오류!
    int i3 = Integer.parseInt("100"); // 메서드의 도움을 받아서 문자열로 바꾼다.
  }
}
