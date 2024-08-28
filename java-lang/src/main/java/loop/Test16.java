package loop;

public class Test16 {
  public static void main(String[] args) {
    int a = 2, b = 1;

    // while 중첩문에서 break 사용 예)ㄴ
    // 5단은 5 * 5 = 25
    // 나머지 단은 1 ~ 9까지 모두 출력한다
    while (a < 10) {
      while (b < 10) {
        System.out.printf("%d * %d = %d\n", a, b, a * b);
        if (a == 5 && b == 5) {
          break;
        }
        b++;
      }
      a++;
      b = 1;

    }
  }
}
