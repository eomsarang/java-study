// 증감 연산자 IV
package study.lang.operator;

public class Exam05 {

  public static void main(String[] args) {
    int i = 2;
    int result = i++ + i++ + i++; // 연산자 우선 순위에 따라 후위 연산자가 먼저 실행된다.

    System.out.println(i);
    System.out.println(result);

    i = 2;
    result = ++i + ++i + ++i;
    System.out.printf("%d, %d\n", i, result);
  }
}
