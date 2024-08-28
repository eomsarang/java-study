package loop;

public class Test12 {
  public static void main(String[] args) {
    int i = 0;

    // break : 반복문 실행 중 중간에 나가는 방법
    while (i < 100) {
      System.out.println(++i);
      if (i == 10) {
        break;
      }
    }
  }
}
