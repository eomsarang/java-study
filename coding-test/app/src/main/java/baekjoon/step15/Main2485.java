package baekjoon.step15;

import java.util.Scanner;

public class Main2485 {

  public static int gcd(int a, int b) {
    while (b != 0) {
      int temp = a % b;
      a = b;
      b = temp;
    }
    return a;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();

    int[] trees = new int[N];
    for (int i = 0; i < N; i++) {
      trees[i] = sc.nextInt();
    }

    int[] diffs = new int[N - 1];
    for (int i = 0; i < N - 1; i++) {
      diffs[i] = trees[i + 1] - trees[i];
    }

    int g = diffs[0];
    for (int i = 1; i < diffs.length; i++) {
      g = gcd(g, diffs[i]);
    }

    int totalTrees = (trees[N - 1] - trees[0]) / g + 1;

    int result = totalTrees - N;

    System.out.println(result);
  }
}
