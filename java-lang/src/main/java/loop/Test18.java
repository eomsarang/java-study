package loop;

public class Test18 {
  public static void main(String[] args) {
    int a = 2, b = 1;

    // while 중첩문에서 바깥 while 문으로 바로 나가기 => break 라벨명
    // => 5 * 5 = 25까지만 출력한다.
    loop: while (a < 10) {
      while (b < 10) {
        System.out.printf("%d * %d = %d\n", a, b, a * b);
        if (a == 5 && b == 5) {
          break loop;
        }
        b++;
      }
      a++;
      b = 1;
    }
  }
}
