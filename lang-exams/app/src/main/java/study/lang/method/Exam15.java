// 메서드: 레퍼런스 다루기
package study.lang.method;

public class Exam15 {

  public static void main(String[] args) {
    // 레퍼런스 다루기 예1:
    // - 객체를 만든 후에 메서드에 전달하여 초기화시키기
    int[] arr = new int[3];
    init(arr);
    print(arr);

    // 레퍼런스 다루기 예2:
    // - 메서드에서 객체를 만든 후에 초기화시킨 후 리턴하기
    int[] arr2 = init2();
    print(arr2);
  }

  static void print(int[] arr) {
    for (int value : arr) {
      System.out.print(value + ",");
    }
    System.out.println();
  }

  // 외부에서 만든 객체를 초기화시킨다.
  static void init(int[] arr) {
    arr[0] = 100;
    arr[1] = 200;
    arr[2] = 300;
  }

  // 내부에서 객체를 만든 후 초기화시켜서 리턴한다.
  static int[] init2() {
    int[] arr = new int[3];
    arr[0] = 111;
    arr[1] = 222;
    arr[2] = 333;
    return arr;
  }

}
