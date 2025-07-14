// 문자의 유니코드
package study.lang.variable;

public class Exam08 {
  public static void main(String[] args){
    // 문자의 유니코드를 알아내는 가장 일반적인 문법은 single quote를 사용하는 것이다.
    char c1 = 'A'; // 'A'는 A 문자의 유니코드인 65를 리턴한다.

    // 이스케이프 문자를 사용하여 유니코드 지정
    char c2 = '\u0041';

    System.out.printf("%c, %c\n", c1, c2);
  }
}
