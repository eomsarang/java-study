// 메서드: call by value, call by reference
package study.lang.method;

public class Exam14 {

  public static void main(String[] args) {
    // call by value
    // - 메서드를 호출할 때 아규먼트로 값을 넘기는 것
    // - 해당 메서드는 호출자의 변수 값을 변경할 수 없다.
    int a = 100;
    int b = 200;
    System.out.printf("main(): a=%d, b=%d\n", a, b);
    swap(a, b);
    System.out.printf("main(): a=%d, b=%d\n", a, b);

    // call by reference
    // - 메서드를 호출할 때 아규먼트로 값을 담은 메모리 주소를 넘기는 것
    // - 해당 메서드에서 메모리의 값을 바꾸면 호출자의 변수 값이 바뀐다.
    // - 자바에서 주소를 넘기는 방법은 객체를 만드는 것이다.
    int[] arr = new int[]{100, 200};
    System.out.printf("main(): arr[0]=%d, arr[1]=%d\n", arr[0], arr[1]);
    swap2(arr); // 배열 객체의 주소를 넘긴다.
    System.out.printf("main(): arr[0]=%d, arr[1]=%d\n", arr[0], arr[1]);

  }

  static void swap(int a, int b) {
    int temp = a;
    a = b;
    b = temp;
    System.out.printf("swap(): a=%d, b=%d\n", a, b);
  }

  static void swap2(int[] arr) {
    int temp = arr[0];
    arr[0] = arr[1];
    arr[1] = temp;
    System.out.printf("swap2(): arr[0]=%d, arr[1]=%d\n", arr[0], arr[1]);
  }
}
