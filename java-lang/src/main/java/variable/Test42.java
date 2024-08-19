package variable;

public class Test42 {
  public static void main(String[] args) {
    // 유니코드 값과 문자 출력
    int c1 = 0x41;

    // println()에 넘어 오는 값이 byte, short, int, long일 경우 그대로 숫자를 10진수로 출력한다.
    System.out.println(c1);

    // 숫자가 아닌 문자를 출력하려면 컴파일러에게 정수 값이 아니라 유니코드 값임을 알려야 한다.
    System.out.println((char) c1); // println()은 유니코드 값에 해당하는 문자를 출력한다.

  }
}
