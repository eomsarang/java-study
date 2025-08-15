package baekjoon.step07;

import java.util.Scanner;

public class Main2566 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int maxVal = -1;
    int maxRow = 0;
    int maxCol = 0;

    for (int i = 1; i <= 9; i++) {
      for (int j = 1; j <= 9; j++) {
        int num = sc.nextInt();
        if (num > maxVal) {
          maxVal = num;
          maxRow = i;
          maxCol = j;
        }
      }
    }

    System.out.println(maxVal);
    System.out.println(maxRow + " " + maxCol);

    sc.close();
  }
}
