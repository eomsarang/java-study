package variable;

public class Test02 {
  public static void main(String[] args) {
    // 변수 사용
    byte b1;

    // b1 = 100;
    // 초기화하지 않은 변수의 값은 조회할 수 없다.
    // => 즉 변수 선언 후 값을 저장한 적이 없는 경우
    System.out.println(b1); // 컴파일 오류!
  }
}
