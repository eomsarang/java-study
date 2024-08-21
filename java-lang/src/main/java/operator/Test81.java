package operator;

public class Test81 {
  public static void main(String[] args) {
    // 삼항 조건 연산자: 조건 ? 값1 : 값2
    System.out.println(true ? "참" : "거짓");
    System.out.println(false ? "참" : "거짓");
    System.out.println(10 > 20 ? "참" : "거짓");
    System.out.println(10 % 2 == 0 ? "짝수" : "홀수");
    System.out.println(11 % 2 == 0 ? "짝수" : "홀수");
    System.out.println((10 & 1) == 0 ? "짝수" : "홀수");
  }
}
