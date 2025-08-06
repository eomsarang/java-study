package baekjoon.step04;

import java.util.Scanner;

public class Main1546 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    double[] scores = new double[N];
    double maxScore = 0;

    for (int i = 0; i < N; i++) {
      scores[i] = sc.nextDouble();
      if (scores[i] > maxScore) {
        maxScore = scores[i];
      }
    }

    double sum = 0;
    for (int i = 0; i < N; i++) {
      scores[i] = (scores[i] / maxScore) * 100;
      sum += scores[i];
    }

    double average = sum / N;
    System.out.println(average);
  }
}
