package literal;

public class Test32 {
  public static void main(String[] args) {
    // 부동소수점 리터럴(floating point literal) - 4바이트 크기와 8바이트 크기
    System.out.println(3.14F); // 4바이트 크기
    System.out.println(3.14f); // 4바이트 크기*
    System.out.println(3.14); // 8바이트 크기*
    System.out.println(3.14d); // 8바이트 크기
    System.out.println(3.14D); // 8바이트 크기

    System.out.println(9876.678f); // 부호 구분 없이 7자리까지 대체로 유효
    System.out.println(9876.345678934567); // 부호 구분 없이 16자리까지 대체로 유효

    System.out.println(9876.6789f); // 7자리 넘어가면 보통 반올림 처리 또는 잘림
    System.out.println(9876.3456789345678); // 16자리 넘어가면 보통 반올림 처리 또는 잘림
  }
}
