// 조건문: switch ~ case ~ default ~
package study.lang.control;

public class Exam06 {

  public static void main(String[] args) {
    // 단순 값을 비교하는 경우 if 문 보다 간결하고 이해하기 쉽다.
    // switch(4바이트 이하의 크기를 갖는 정수 타입 / 문자열 타입 / enum 타입) {
    //   case 리터럴:
    //     문장; 문장; 문장;
    //     break;
    //   default:
    //     문장; 문장;
    // }

    int menuNo = 1;
    switch (menuNo) {
      case 1:
        System.out.println("회원관리");
        break;
      case 2:
        System.out.println("게시글관리");
        break;
      default:
        System.out.println("무효한 메뉴입니다!");
    }

  }
}
