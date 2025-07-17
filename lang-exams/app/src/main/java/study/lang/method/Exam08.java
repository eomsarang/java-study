// 메서드: 가변 파라미터의 한계 II
package study.lang.method;

public class Exam08 {

  public static void main(String[] args) {
    // 가변 파라미터 다음에 다른 파라미터가 와서는 안된다.
//    sum( 100, 90, 80, "홍길동"); // 컴파일 오류!

    // 배열 파라미터는 어떤 위치에 선언해도 상관없다.
    // 왜? 호출할 때 배열을 만들어서 그 주소를 넘기기 때문이다.
    sum2(new int[]{100, 90, 80}, "임꺽정");
  }

  // 가변 파라미터는 맨 마지막에 선언되어야 한다.
//  static void sum(int... scores, String name) { // 컴파일 오류!
//    int result = 0;
//    for (int score : scores) {
//      result += score;
//    }
//    System.out.printf("%s: 총점 %d, 평균 %d\n", name, result, result / scores.length);
//  }

  // 배열 파라미터
  static void sum2(int[] scores, String name) {
    int result = 0;
    for (int score : scores) {
      result += score;
    }
    System.out.printf("%s: 총점 %d, 평균 %d\n", name, result, result / scores.length);
  }
}
