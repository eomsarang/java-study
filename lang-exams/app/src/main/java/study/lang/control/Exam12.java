// 반복문: do ~ while
package study.lang.control;

public class Exam12 {

  public static void main(String[] args) {
    // do 문장; while (boolean) 문장;
    // 애 {문장; 문장; ...} while (boolean);

    // 먼저 실행한 후 계속 실행할 지 조건을 묻는 경우
    int a = 0;
    do {
      System.out.print(a + ",");
      a++;
    } while (a < 10);
    System.out.println();
  }
}
