// 문자열 리터럴
package study.lang.literal;

public class Exam05 {
  public static void main(String[] args){
    System.out.println(""); // 빈 문자열 가능
    System.out.println("A");
    System.out.println("ABC");

    System.out.println("ABC\u2665DEF"); // \u0000 ~ \uffff(0 ~ 65535)
    System.out.println("ABC\101DEF"); // \0 ~ 377(0 ~ 255)
    System.out.println("ABC\nDEF"); // Line Feed
    System.out.println("ABCXYZ\rDEF"); // Carriage Return
    System.out.println("ABCXYZ\tDEF"); // Horizontal tab
    System.out.println("ABCXYZ\fDEF"); // Form Feed
    System.out.println("ABCXYZ\fDEF"); // Form Feed
    System.out.println("ABC\"XYZ\"DEF"); // Double Quote
    System.out.println("ABC'XYZ'DEF"); // Single Quote
    System.out.println('"'); // Single Quote
    System.out.println('\''); // Single Quote
    System.out.println('\\'); // Backslash
  }
}
