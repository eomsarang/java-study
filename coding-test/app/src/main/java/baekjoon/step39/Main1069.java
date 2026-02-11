package baekjoon.step39;

import java.util.Scanner;

public class Main1069 {

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);

    double X = sc.nextDouble();
    double Y = sc.nextDouble();
    double D = sc.nextDouble();
    double T = sc.nextDouble();

    double dist = Math.sqrt(X * X + Y * Y);

    double answer = dist;

    int k = (int) (dist / D);

    answer = Math.min(answer, k * T + (dist - k * D));

    answer = Math.min(answer, (k + 1) * T);

    if (k == 0) {
      answer = Math.min(answer, T + (D - dist));
      answer = Math.min(answer, 2 * T);
    }

    System.out.printf("%.15f\n", answer);
  }
}
