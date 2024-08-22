package operator;

public class Test13 {
  public static void main(String[] args) {
    // 자바의 기본 연산은 int
    // byte, short ===> int 변환 후 연산 실행
    byte b1 = 5, b2 = 6, b3;

    // byte b3 = b1+ b2; // 1바이트메모리 = 4바이트메모리: 컴파일 오류!
    // short s3 = b1 + b2; // 2바이트메모리 = 4바이트메모리: 컴파일 오류!
    int i3 = b1 + b2; // 4바이트메모리= 4바이트메모리 : Ok

    short s1 = 5, s2 = 6;
    // short s3 = s1+ s2; // 컴파일 오류!
    i3 = s1 + s2; // 4바이트메모리(int 메모리)에 s1, s2의 값을 저장한 후 연산을 수행한다.

    i3 = b1 + s1; // b1, s1 값을 int 타입 메모리에 저장한 후 연산을 수행한다.
  }
}
