package operator;

public class Test14 {
  public static void main(String[] args) {
    // 명시적 형변환
    byte b1 = 5, b2 = 6;
    byte b3 = (byte) (b1 + b2); // 계산 결과를 1바이트 크기로 강제 지정할 수 있다.
    System.out.println(b3);

    // 만약 해당 타입의 메모리로 값을 넣을 때 메모리 크기가 작다면 값이 잘린다.

    b1 = 127;
    b2 = 127;
    b3 = (byte) (b1 + b2); // 메모리 큰기보다 값이 클 경우, 명시적 형변환으로 인해 값이 잘린다.
    System.out.println(b3);
  }
}
