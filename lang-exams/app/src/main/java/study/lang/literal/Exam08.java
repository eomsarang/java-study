// 문자 리터럴 범위
package study.lang.literal;

public class Exam08 {
  public static void main(String[] args){
    // 문자 리터럴은 2바이트 크기의 메모리에 저장된다.
    // 유효범위: 0 ~ 65535(유니코드 값)
    System.out.println('\u0000');
    System.out.println('\u0041'); // A
    System.out.println('\u0061'); // a
    System.out.println('\u0031'); // 1
    System.out.println('\uac00'); // 가
    System.out.println('\uffff');

  }
}
