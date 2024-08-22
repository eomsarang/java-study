package operator;

public class Test12 {
  public static void main(String[] args) {
    // 산술 연산자 우선순위
    // => ()
    // => * / %
    // => + -
    System.out.println(2 + 3 * 4); // 14
    System.out.println(2 + 3 * 4 / 6); // 4
    System.out.println((2 * 3 - 3 * 4 + 5 * 2)); // 4
    System.out.println((2 + 3) * 4); // 20
  }
}
