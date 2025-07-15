// 값 저장 - 같은 타입일 경우
package study.lang.variable;

public class Exam18 {

  public static void main(String[] args) {
    byte b = 100;
    short s = 100;
    int i = 100;
    long l = 100;
    char c = 'A'; // 실제 저장되는 것은 0x41 = 65

    // 같은 타입일 경우
    // - 정수: 작은 메모리의 값은 큰 메모리의 변수에 저장할 수 있다.
    byte b2 = b;
    short s2 = b2;
    int i2 = s;
    long l2 = i;

    // char c2 = b; // 음수를 저장할 수 없어 컴파일 오류
    // s2 = c; // short 메모리의 양수 최대 값은 32767까지만 저장할 수 있다. 컴파일 오류!
    i2 = c; // OK!

    // - 부동소수점
    float f = 3.14f;
    double d = 3.14;

    float f2 = f;
    double d2 = f;

  }
}
