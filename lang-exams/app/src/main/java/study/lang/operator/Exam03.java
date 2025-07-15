// 증감 연산자 II
package study.lang.operator;

public class Exam03 {

  public static void main(String[] args) {
    int i = 100;
    int j = 100;

    System.out.println(i++);
    // 위 문장은 컴파일러가 다음 문장으로 바꾼다.
//    System.out.println(i);
//    i = i + 1;

    System.out.println(j--);
    // 위 문장은 컴파일러가 다음 문장으로 바꾼다.
//    System.out.println(j);
//    j = j - 1;

    i = 100;
    j = 100;

    System.out.println(++i);
    // 위 문장은 컴파일러가 다음 문장으로 바꾼다.
//    i = i + 1;
//    System.out.println(i);

    System.out.println(--j);
    // 위 문장은 컴파일러가 다음 문장으로 바꾼다.
//    j = j - 1;
//    System.out.println(j);
  }
}
