// 메서드: Object 파라미터
package study.lang.method;

public class Exam09 {

  public static void main(String[] args) {
    print("홍길동", 20, 85.5f, false, 'M');
  }

  static void print(Object... params) {
    for (Object obj : params) {
      System.out.println(obj);
    }
  }

}
