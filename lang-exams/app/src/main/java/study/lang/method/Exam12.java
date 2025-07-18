// 메서드: 중첩 호출
package study.lang.method;

public class Exam12 {

  public static void main(String[] args) {
    // 일반적인 메서드 호출
    int result = toDouble(2);
    result = toDouble(result);
    result = toDouble(result);
    System.out.println(result);

    // 실무: 메서드 중첩 호출
    System.out.println(toDouble(toDouble(toDouble(2))));
  }

  // 메서드 이름
  // - 동사구, 전치사구, 명사구
  static int toDouble(int value) {
    return value * 2;
  }

}
