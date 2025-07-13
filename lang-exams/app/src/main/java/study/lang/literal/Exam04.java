// 문자 리터럴
package study.lang.literal;

public class Exam04 {
  public static void main(String[] args){

    System.out.println('A');
    System.out.println('\u0041'); // 문자의 16진수 유니코드 값, A <== 실무에서는 16진수를 사용
    System.out.println('\101'); // 문자의 8진수 유니코드 값, A
    System.out.println('\102'); // 문자의 8진수 유니코드 값, B
    System.out.println('\61'); // 문자의 유니코드 값, 1
    System.out.println('\62'); // 문자의 유니코드 값, 2
    System.out.println('\7'); // 문자의 유니코드 값, Bell
    System.out.println('\377'); // 문자의 유니코드 값, 최대 1바이트 값인 255까지만 가능

    // 보통 키보드로 직접 입력이 불가능한 문자를 표현하고 싶을 때 유니코드 값으로 지정한다.
    System.out.println('\u2665');
    // System.out.println('\u1f495'); // 유니코드는 0x0000 ~ 0xffff 까지만 가능
    System.out.println(Character.toChars(0x1f495)); // <=== 0xffff를 초과하는 경우

    // Escape 문자
    System.out.println('\n'); // 줄바꿈 기능. 더 많은 것은 문자열 리터열에서 확인!

    // System.out.println(''); // 빈 문자 불가능
  }
}
