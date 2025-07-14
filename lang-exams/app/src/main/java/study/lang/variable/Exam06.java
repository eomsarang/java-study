// 변수 중복 불가
package study.lang.variable;

public class Exam06 {
  public static void main(String[] args){
    int i = 100;

    // int i = 200; // 같은 이름의 변수를 중복 선언할 수 없다.
    // float i = 3.14; // 타입에 상관없이 같은 이름의 변수를 중복 선언할 수 없다.
    {
      // int i = 300; // 메서드 블록 안에서는 중복 불가!
      // float i = 3.14; // 타입에 상관없이 같은 이름의 변수를 중복 선언할 수 없다.
    }
  }

  public static void m1() {
    // 메서드 마다 고유의 메모리 영역을 가진다.
    // 그래서 다른 메서드에서 사용한 변수 이름을 중복해서 사용할 수 있다.
    int i = 200;
  }
}
