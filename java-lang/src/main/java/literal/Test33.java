package literal;

public class Test33 {
  public static void main(String[] args) {
    // 부동소수점 리터럴(floating point literal) - 32비트 2진수 값과 64비트 2진수 값
    System.out.println(12.375f); // 4바이트 크기
    System.out.println(-12.375f); // 4바이트 크기
    System.out.println(12.375); // 8바이트 크기
    System.out.println(-12.375); // 8바이트 크기
  }
}
