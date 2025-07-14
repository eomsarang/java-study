// 변수의 생성과 소멸
package study.lang.variable;

public class Exam16 {

  static int a; // 클래스가 로딩될 때 생성, JVM 종료할 때 소멸
  int b; // new 명령을 실행할 때 생성, 가비지 컬렉터에 의해 수집될 때 종료

  public static void main(String[] args/* 로컬 변수 = 파라미터 */) {
    int i = 100; // 로컬 변수
    // 로컬 변수는 메서드가 호출될 때 생성, 호출이 완료되어 리턴될 때 소멸
  }
}
