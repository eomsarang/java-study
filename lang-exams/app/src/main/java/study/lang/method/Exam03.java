// 메서드: 가변 파라미터
package study.lang.method;

public class Exam03 {

  public static void main(String[] args) {
    int result = Exam03.sum(10, 20, 30);
    System.out.println(result);
    // 아규먼트 개수는 파라미터 개수와 일치해야 한다.
//    sum(10, 20) // 컴파일 오류!
//    sum(10, 20, 30, 40) // 컴파일 오류!

    System.out.println(sum2(10, 20, 30));
    System.out.println(sum2());
    System.out.println(sum2(10, 20, 30, 40, 50));
  }

  // 가변 파라미터 사용 전
  static int sum(int a, int b, int c) {
    return a + b + c;
  }

  // 가변 파라미터 사용 후
  static int sum2(int... values) {
    // 가변 파라미터는 배열처럼 사용한다. 배열의 크기는 아규먼트의 개수와 같다.
    // 아규먼트가 없으면 배열의 크기는 0이다. null이 아니다.
    int result = 0;
    for (int value : values) {
      result += value;
    }
    return result;
  }
}
