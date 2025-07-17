// 메서드: 가변 파라미터 vs 배열 파라미터
package study.lang.method;

public class Exam06 {


  public static void main(String[] args) {

    // 가변 파라미터는 아규먼트를 낱개로 넘기거나 배열에 담아 넘길 수 있다.
    System.out.println(sum(10, 20, 30));
    System.out.println(sum(new int[]{10, 20, 30}));

    // 배열 파라미터는 아규먼트를 낱개로 넘길 수 없다. 오직 배열에 담아서 넘겨야 한다.
//    System.out.println(sum2(10, 20, 30)); // 컴파일 오류!
    System.out.println(sum2(new int[]{10, 20, 30}));

  }

  // 가변 파라미터
  static int sum(int... values) {
    int result = 0;
    for (int value : values) {
      result += value;
    }
    return result;
  }

  // 배열 파라미터
  static int sum2(int[] values) {
    int result = 0;
    for (int value : values) {
      result += value;
    }
    return result;
  }
}
