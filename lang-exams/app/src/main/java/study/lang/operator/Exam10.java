// 논리 연산자
package study.lang.operator;

public class Exam10 {

  public static void main(String[] args) {
    boolean True = true;
    boolean False = false;
    System.out.println(True || True);
    System.out.println(True || False);
    System.out.println(False || True);
    System.out.println(False || False);

    System.out.println(True && True);
    System.out.println(True && False);
    System.out.println(False && True);
    System.out.println(False && False);

    System.out.println(!True);
    System.out.println(!False);

    System.out.println(True ^ True);
    System.out.println(True ^ False);
    System.out.println(False ^ True);
    System.out.println(False ^ False);
  }
}
