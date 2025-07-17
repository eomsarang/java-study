// 메서드: 가변 파라미터의 한계
package study.lang.method;

public class Exam07 {

  public static void main(String[] args) {

    // 첫 번째 values 가변 파라미터가 받을 값들과 두 번째 values2 가변 파라미터가 받을 값을 구분할 수 없다.
    // 따라서 한 메서드에 가변 파라미터를 2개 이상 선언할 수 없다.
//    int[] sums = sum(1, 2, 3, 100, 200, 300, 400);
//    System.out.printf("%d, %d\n", sums[0], sums[1]);

    // 배열 파라미터는 여러 개 사용 가능!
    // 왜? 호출할 때 배열에 담아서 넘기기 때문이다.
    int[] sums = sum2(new int[]{1, 2, 3}, new int[]{100, 200, 300, 400});
    System.out.printf("%d, %d\n", sums[0], sums[1]);
  }

  // 한 메서드에 가변 파라미터는 한 개만 가능하다.
//  static int[] sum(int... values, int... values2) {
//    int[] results = new int[2];
//    for (int value : values) {
//      results[0] += value;
//    }
//    for (int value : values2) {
//      results[1] += value;
//    }
//    return results;
//  }

  // 배열 파라미터
  static int[] sum2(int[] values, int[] values2) {
    int[] results = new int[2];
    for (int value : values) {
      results[0] += value;
    }
    for (int value : values2) {
      results[1] += value;
    }
    return results;
  }
}
