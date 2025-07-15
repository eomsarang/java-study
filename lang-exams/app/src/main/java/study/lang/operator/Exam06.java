// 연산자 우선순위:
// 전위연산자, 후위연산자
// ( )
// *, /, %
// +, -
package study.lang.operator;

public class Exam06 {

  public static void main(String[] args) {
    System.out.println(2 + 3 * 4 - 1);
    System.out.println(2 + 3 * (4 - 1));
    System.out.println(8 * 3 % 7); // 3
    System.out.println(2 % 4 * 3); // 6
    System.out.println(2 % 3 * (4 - 1));
    int i = 2;
    System.out.println(++i * (i++ + ++i)); // 3 * (3 + 5)

  }
}
