// 조건문: case 값 II
package study.lang.control;

public class Exam09 {

  public static void main(String[] args) {
   enum Role {
     USER, MANAGER, GUEST
   }

   Role role = Role.GUEST;
    switch (role) {
      case USER: break;
      case MANAGER: break;
      case GUEST: break;
    }
  }
}
