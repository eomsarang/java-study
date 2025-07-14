// 문자 변수 활용
package study.lang.variable;

public class Exam07 {
  public static void main(String[] args){
    // 문자 변수는 유니코드 값을 저장한다.
    // 유니코드는 문자에 대해 부여한 정수 값(0~ 65535)이다.
    char c;
    c = 'A'; // c 변수에 저장되는 것은 A 문자의 유니코드 값인 0x41(65)이 저장된다.

    int i = c; // c 변수에 저장된 값은 정수 값이므로 정수 변수인 i에 저장할 수 있다.

    System.out.println(c); // 변수의 타입이 char일 경우 정수 값을 유니코드로 인식하여 해당 문자를 출력한다.
    System.out.println(i); // 변수의 타입이 int일 경우 그대로 정수 값을 출력한다.

    c = 65; // 문자의 유니코드를 알고 있다면 직접 유니코드 값을 저장해도 된다.
    System.out.println(c);
  }
}
