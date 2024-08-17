package literal;

public class Test22 {
  public static void main(String[] args) {
    // 정수 리터럴(literal) - 4바이트 정수와 8비이트 정수
    System.out.println(100); // 4바이트 크기의 정수
    System.out.println(100L); // 8바이트 크기의 정수
    System.out.println(100l); // 8바이트 크기의 정수

    System.out.println(-2_147_483_648); // 4바이트 크기의 정수(최소 값)
    System.out.println(2_147_483_647); // 4바이트 크기의 정수(최대 값)
    System.out.println(-9_223_372_036_854_775_808L); // 8바이트 크기의 정수(최소 값)
    System.out.println(9_223_372_036_854_775_807L); // 8바이트 크기의 정수(최대 값)
  }
}
