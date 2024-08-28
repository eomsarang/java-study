package loop;

public class Test13 {
  public static void main(String[] args) {
    int i = 0;

    // continue : 반복문 실행 중 중간에 조건 검사로 바로 가는 방법
    while (i < 20) {
      i++;
      if (i % 2 == 0) {
        continue;
      }
      System.out.println(i);
    }
  }
}
