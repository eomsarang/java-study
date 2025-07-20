// 메서드: 사용 후 - Refactoring 기법 중 extract method
package study.lang.method;

import java.util.Scanner;

// 1단계: 공백 출력하는 코드를 메서드로 추출하기
// 2단계: 별 출력 코드를 메서드로 추출하기
public class Exam21 {

  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);
    System.out.print("밑변의 길이? ");
    int len = keyScan.nextInt();
    keyScan.close();

    int starLen = 1;
    while (starLen <= len) {
      int spaceLen = (len - starLen) / 2;
      printSpaces(spaceLen);

      // 별 출력
      printStars(starLen);

      // 출력 줄 바꾸기
      System.out.println();
      starLen += 2;
    }
  }

  static void printSpaces(int size) {
    int spaceCnt = 1;
    while (spaceCnt <= size) {
      System.out.print(" ");
      spaceCnt++;
    }
  }

  static void printStars(int length) {
    int starCnt = 1;
    while (starCnt <= length) {
      System.out.print("*");
      starCnt++;
    }
  }
}
