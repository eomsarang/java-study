// 조건문: break
package study.lang.control;

public class Exam10 {

  public static void main(String[] args) {
   enum Role {
     DEVELOPER, MANAGER, SECURITY
   }

   Role role = Role.SECURITY;

    switch (role) {
      case DEVELOPER:
        System.out.println("이력서");
        System.out.println("자격증");
        System.out.println("코딩테스트");
        break;
      case MANAGER:
        System.out.println("이력서");
        System.out.println("자격증");
        break;
      case SECURITY:
        System.out.println("이력서");
        break;
    }

    System.out.println("-----------------------------");
    // break 문을 고의적으로 생략하여 흐름을 제어할 수 있다.
    switch (role) {
      case DEVELOPER:
        System.out.println("코딩테스트");
      case MANAGER:
        System.out.println("자격증");
      case SECURITY:
        System.out.println("이력서");
    }
  }
}
