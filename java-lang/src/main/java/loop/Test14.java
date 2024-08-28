package loop;

public class Test14 {
  public static void main(String[] args) {
    int a = 2, b = 1;

    // while을 중첩해서 사용하는 방법
    while (a < 10) {
      while (b < 10) {
        System.out.printf("%d * %d = %d\n", a, b, a * b);
        b++;
      }
      a++;
      b = 1;
    }
  }
}
