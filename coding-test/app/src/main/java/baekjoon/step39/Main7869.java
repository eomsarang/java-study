package baekjoon.step39;

import java.util.Scanner;

public class Main7869 {

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);

    double x1 = sc.nextDouble();
    double y1 = sc.nextDouble();
    double r1 = sc.nextDouble();
    double x2 = sc.nextDouble();
    double y2 = sc.nextDouble();
    double r2 = sc.nextDouble();

    double d = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));

    double result;

    if (d >= r1 + r2) {
      result = 0.0;
    } else if (d <= Math.abs(r1 - r2)) {
      double r = Math.min(r1, r2);
      result = Math.PI * r * r;
    } else {
      double cos1 = (r1 * r1 + d * d - r2 * r2) / (2 * r1 * d);
      double cos2 = (r2 * r2 + d * d - r1 * r1) / (2 * r2 * d);

      cos1 = Math.max(-1.0, Math.min(1.0, cos1));
      cos2 = Math.max(-1.0, Math.min(1.0, cos2));

      double theta1 = 2 * Math.acos(cos1);
      double theta2 = 2 * Math.acos(cos2);

      result =
          0.5 * r1 * r1 * (theta1 - Math.sin(theta1))
              + 0.5 * r2 * r2 * (theta2 - Math.sin(theta2));
    }

    System.out.printf("%.3f\n", result);
  }
}
