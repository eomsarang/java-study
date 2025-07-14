// 변수와 메모리 영역
package study.lang.variable;

public class Exam17 {

  static int a; // Method Area 영역에 생성된다.
  int b; // Heap 영역에 생성된다.

  public static void main(String[] args/* 로컬 변수 = 파라미터 */) {
    int i = 100; // 로컬 변수
    // 로컬 변수는 Stack 영역에 생성된다.
    m1();

    Exam17 obj = new Exam17();
    obj.m2();
  }

  static void m1() {
    int d = 200;
  }

  void m2() {
    int e = 300;
  }
}
