// 반복문: while
package study.lang.control;

public class Exam11 {

  public static void main(String[] args) {
    // while (boolean) 문장;
    // while (boolean) {문장; 문장; ... }
    int a = 0;
    while (a < 5) {
      System.out.print(a + ",");
      a++;
    }
    System.out.println();

    a = 0;
    while (a < 10) {
      System.out.print(a + ",");
      if (a == 5)
        break; // 가장 가까운 반복문 또는 switch 문을 나간다.
      a++;
    }
    System.out.println();

    a = 0;
    while (a < 10) {
      if (a == 5) {
        a++;
        continue; // 가장 가까운 반복문의 조건으로 보낸다.
      }
      System.out.print(a + ",");
      a++;
    }
    System.out.println();
  }
}
