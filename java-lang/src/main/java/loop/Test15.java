package loop;

public class Test15 {
  public static void main(String[] args) {
    int a = 2, b = 1;

    // while 중첩문에서 break 사용 예
    while (a < 10) {
      if (a == 6) {
        break;
      }
      while (b < 10) {
        System.out.printf("%d * %d = %d\n", a, b, a * b);
        b++;
      }
      a++;
      b = 1;
    }
  }
}
