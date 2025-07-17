// 메서드: 가변 파라미터에 아규먼트 넘기는 방법
package study.lang.method;

public class Exam04 {

  public static void main(String[] args) {
    // 아규먼트를 낱개로 넘기기
    System.out.println(sum(10, 20, 30));

    // 아규먼트를 배열에 담아서 넘길 수 있다.
    int[] arr = new int[]{10, 20, 30};
    System.out.println(sum(arr));
  }

  static int sum(int... values) {
    int result = 0;
    for (int value : values) {
      result += value;
    }
    return result;
  }
}
