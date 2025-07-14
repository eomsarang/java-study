// 레퍼런스 변수
package study.lang.variable;

public class Exam09 {
  public static void main(String[] args){
    // 레퍼런스는 객체의 주소 값을 저장하는 변수이다.
    java.util.Date today = new java.util.Date();
    java.util.Date date = today; // today에 저장된 객체 주소를 date 변수에 복사한다.

    System.out.println(date);
  }
}
