package baekjoon.step35;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main4386 {

  static class Star {

    double x, y;

    Star(double x, double y) {
      this.x = x;
      this.y = y;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    Star[] stars = new Star[n];
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      double x = Double.parseDouble(st.nextToken());
      double y = Double.parseDouble(st.nextToken());
      stars[i] = new Star(x, y);
    }

    boolean[] visited = new boolean[n];
    double[] minDist = new double[n];
    Arrays.fill(minDist, Double.MAX_VALUE);

    minDist[0] = 0;
    double totalCost = 0;

    for (int i = 0; i < n; i++) {
      int cur = -1;
      double min = Double.MAX_VALUE;

      for (int j = 0; j < n; j++) {
        if (!visited[j] && minDist[j] < min) {
          min = minDist[j];
          cur = j;
        }
      }

      visited[cur] = true;
      totalCost += min;

      for (int j = 0; j < n; j++) {
        if (!visited[j]) {
          double dist = distance(stars[cur], stars[j]);
          if (dist < minDist[j]) {
            minDist[j] = dist;
          }
        }
      }
    }

    System.out.printf("%.2f\n", totalCost);
  }

  static double distance(Star a, Star b) {
    return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
  }
}
