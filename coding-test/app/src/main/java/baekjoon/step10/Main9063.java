package baekjoon.step10;

import java.util.Scanner;

public class Main9063 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    int minX = Integer.MAX_VALUE;
    int maxX = Integer.MIN_VALUE;
    int minY = Integer.MAX_VALUE;
    int maxY = Integer.MIN_VALUE;

    for (int i = 0; i < N; i++) {
      int x = sc.nextInt();
      int y = sc.nextInt();

      if (x < minX) {
        minX = x;
      }
      if (x > maxX) {
        maxX = x;
      }
      if (y < minY) {
        minY = y;
      }
      if (y > maxY) {
        maxY = y;
      }
    }

    int width = maxX - minX;
    int height = maxY - minY;

    int area = width * height;
    System.out.println(area);

    sc.close();
  }
}
