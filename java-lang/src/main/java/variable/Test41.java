package variable;

public class Test41 {
  public static void main(String[] args) {
    // 문자 변수와 값의 범위
    // => 문자의 Unicode(UTF-16BE) 값을 저장한다.
    char c1 = 0;
    System.out.println(c1); // 유니코드 값이 가리키는 문자를 출력한다.

    c1 = 65535;
    System.out.println(c1); // 유니코드 값이 가리키는 문자를 출력한다.

    c1 = 0x41; // 'A'의 유니코드 값
    System.out.println(c1); // 유니코드 값이 가리키는 문자를 출력한다.

    c1 = 65; // 'A'의 유니코드 값
    System.out.println(c1); // 유니코드 값이 가리키는 문자를 출력한다.

    c1 = 0xac00; // '가'의 유니코드 값
    System.out.println(c1); // 유니코드 값이 가리키는 문자를 출력한다.

    // 문자의 유니코드 값을 알아내는 방법
    c1 = 'A'; // '문자' ==> 해당 문자의 유니코드를 리턴한다. 즉 c1 변수에 0x41(65) 값이 저장된다.
    System.out.println(c1);

    // char 변수에 유니코드 값을 저장할 때 ''(single quote)연산자를 주로 사용한다.
    // 왜? 모든 문자의 유니코드를 암기할 수 없다.
  }
}
