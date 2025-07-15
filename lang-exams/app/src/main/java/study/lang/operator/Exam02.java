// 증감 연산자
package study.lang.operator;

public class Exam02 {

  public static void main(String[] args) {
    int i = 100;
    int j = 100;

    i++; // 후위 연산자
    j--; // 후위 연산자
    System.out.println(i);
    System.out.println(j);

    i = 100;
    j = 100;

    ++i; // 전위 연산자
    --j; // 전위 연산자
    System.out.println(i);
    System.out.println(j);
  }
}
