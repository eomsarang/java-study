// 메서드: 가변 파라미터에 배열을 넘길 때
package study.lang.method;

public class Exam05 {

  static int[] arr = new int[]{10, 20, 30};

  public static void main(String[] args) {

    System.out.println(sum(arr));
  }

  static int sum(int... values) {
    System.out.println(arr == values); // 배열을 넘기는 경우 values는 그 배열 주소를 그대로 받는다.
    int result = 0;
    for (int value : values) {
      result += value;
    }
    return result;
  }
}
