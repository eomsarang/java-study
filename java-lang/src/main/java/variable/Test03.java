package variable;

public class Test03 {
  public static void main(String[] args) {
    // 잘못된 변수 선언
    byte b1;

    // 같은 이름의 변수를 중복 선언할 수 없다.
    // byte b1; // 컴파일 오류

    // 변수의 타입을 바꿀 수 없다.
    // float b1; // 컴파일 오류

    // 결론:
    // - 자바는 static type binding 방식으로 변수를 관리한다.
    // - 즉 변수의 타입은 선언할 때 고정된다.

  }
}
