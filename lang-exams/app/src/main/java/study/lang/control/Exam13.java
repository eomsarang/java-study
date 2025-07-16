// 반복문: 중첩된 반복문 탈출
package study.lang.control;

public class Exam13 {

  // 중첩된 반복문
  public static void main(String[] args) {
    int i = 2, j = 1;

    while (i < 10) {
      j = 1;
      while (j < 10) {
        System.out.printf("%d * %d = %d\n",i, j, i * j);
        j++;
      }
      i++;
    }

    System.out.println("--------------------------");

    // 중첩된 반복문 탈출
      i = 2;
      loop1:
      while (i < 10) {
        j = 1;
        while (j < 10) {
          System.out.printf("%d * %d = %d\n",i, j, i * j);
          if (i == 5 && j == 5) {
            break loop1;
          }
          j++;
        }
        i++;
      }
      System.out.println("끝!");

    }
}
