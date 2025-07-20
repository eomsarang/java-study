// 메서드: 사용 후 - Refactoring 기법 중 extract method
package study.lang.method;

import java.util.Scanner;

// 1단계: 공백 출력하는 코드를 메서드로 추출하기
// 2단계: 별 출력 코드를 메서드로 추출하기
// 3단계: while 문을 for 문으로 변경
// 4단계: 공백 개수를 계산하는 코드를 메서드로 추출하기
public class Exam23 {

  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);
    System.out.print("밑변의 길이? ");
    int len = keyScan.nextInt();
    keyScan.close();

    for (int starLen = 1; starLen <= len; starLen += 2) {
      printSpaces(sizeOfSpaces(len, starLen));
      printStars(starLen);
      System.out.println();
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

  static int sizeOfSpaces(int len, int starLen) {
    int spaceLen = (len - starLen) / 2;
    return spaceLen;
  }
}
