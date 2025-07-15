// 증감 연산자 III
package study.lang.operator;

public class Exam04 {

  public static void main(String[] args) {
    int i = 100;
    i = i++;
    // 컴파일러는 위 문장을 다음 문장으로 바꾼다.
//    int temp = i;
//    i = i + 1;
//    i = temp;

    System.out.println(i);
  }
}
