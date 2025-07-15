// 비트 연산자
package study.lang.operator;

public class Exam11 {

  public static void main(String[] args) {
    int a = 0b01101100;
    int b = 0b10100110;

    System.out.println(a | b); //0b11101110 = 0xee
    System.out.println(Integer.toBinaryString(a | b));
    System.out.println(Integer.toBinaryString(a & b)); // 0b00100100
    System.out.println(Integer.toBinaryString(a ^ b)); // 0b11001010
    System.out.println(Integer.toBinaryString(~a)); // 0b10010011
  }
}
