// 전위연산자, 후위연산자
package study.lang.operator;

public class Exam07 {

  public static void main(String[] args) {
    int i = 100;
    // System.out.println(++i++); // 전위 연산자나 후위 연산자를 실행한 후 그 자리에 값을 놓는다.
    // 예) ++i를 먼저 실행했다면, 101++ 이 된다.
    //    i++ 을 먼저 실행했다면, ++101이 문장이 된다.
    // 문제는 ++ 연산자는 반드시 변수가 와야 한다.

    // System.out.println(++(i++)); // i++ 실행한 자리에 값이 놓인다. ++101? 이 문장은 실행할 수 없다.
  }
}
