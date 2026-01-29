package baekjoon.step37;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main13018 {

  static int gcd(int a, int b) {
    while (b != 0) {
      int t = a % b;
      a = b;
      b = t;
    }
    return a;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    if (n == 1) {
      if (k == 0) {
        System.out.println(1);
      } else {
        System.out.println("Impossible");
      }
      return;
    }

    if (k > n - 1 || ((n - 1 - k) & 1) == 1) {
      System.out.println("Impossible");
      return;
    }

    int[] A = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      A[i] = i;
    }

    int need = (n - 1) - k;
    boolean[] used = new boolean[n + 1];

    for (int i = 2; i <= n && need > 0; i++) {
      if (used[i]) {
        continue;
      }
      for (int j = i + 1; j <= n; j++) {
        if (used[j]) {
          continue;
        }
        if (gcd(i, j) == 1) {
          A[i] = j;
          A[j] = i;
          used[i] = used[j] = true;
          need -= 2;
          break;
        }
      }
    }

    if (need != 0) {
      System.out.println("Impossible");
      return;
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= n; i++) {
      sb.append(A[i]).append(' ');
    }
    System.out.println(sb.toString().trim());
  }
}
