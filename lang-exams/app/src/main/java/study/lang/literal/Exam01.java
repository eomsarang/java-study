// 리터럴
package study.lang.literal;

public class Exam01 {
  public static void main(String[] args){
    // 자바에서 값을 표현하는 문법
    System.out.println(100); // 4바이트 정수, 실무
    System.out.println(100L); // 8바이트 정수, 실무
    System.out.println(100l); // 8바이트 정수

    System.out.println(3.14f); // 4바이트 부동소수점, 실무
    System.out.println(3.14F); // 4바이트 부동소수점
    System.out.println(3.14); // 8바이트 부동소수점, 실무
    System.out.println(3.14d); // 8바이트 부동소수점
    System.out.println(3.14D); // 8바이트 부동소수점

    System.out.println(true); // 논리
    System.out.println(false); // 논리

    System.out.println('A'); // 문자
    System.out.println('가'); // 문자
    // System.out.println(''); // 컴파일 오류!

    System.out.println("ABC"); // 문자열
    System.out.println("A"); // 문자열
    System.out.println(""); // 빈문자열 가능
  }
}
