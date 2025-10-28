package baekjoon.step23;

import java.util.Scanner;

public class Main13305 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    long[] dist = new long[N - 1];
    long[] price = new long[N];

    for (int i = 0; i < N - 1; i++) {
      dist[i] = sc.nextLong();
    }

    for (int i = 0; i < N; i++) {
      price[i] = sc.nextLong();
    }

    long totalCost = 0;
    long minPrice = price[0];

    for (int i = 0; i < N - 1; i++) {
      if (price[i] < minPrice) {
        minPrice = price[i];
      }
      totalCost += minPrice * dist[i];
    }

    System.out.println(totalCost);
  }
}
