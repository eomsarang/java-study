// 상수: 값을 한 번 할당하면 변경할 수 없는 변수
package study.lang.variable;

public class Exam14 {
  public static void main(String[] args){
    // 변수
    int i = 100;
    i = 200;
    i = 300;

    // 상수
    final int j = 100;
    // j = 200;

    final int k;
    k = 100; // 단 한 번만 값을 저장할 수 있다.
    // k = 200;

    // 보통 상수 변수는 바로 알아 볼 수 있도록 대문자로 작성한다.
    final float PI = 3.14159f;
  }
}
