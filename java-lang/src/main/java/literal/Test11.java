package literal;

public class Test11 {
  public static void main(String[] args) {
    // 문자열 리터럴(literal)
    System.out.println("가각간");
    // 키보드로 입력 불가능한 경우 직접 문자의 코드 값을 지정할 수 있다.
    // \u 문자코드(16진수)
    // 문자의 코드 값? 문자를 메모리에 저장할 때 사용하는 값
    // 자바는 유니코드(2바이트)를 사용한다.
    System.out.println("\uac00\uac01\uac04\u2126");
  }
}
