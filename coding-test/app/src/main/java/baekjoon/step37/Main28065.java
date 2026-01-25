package baekjoon.step37;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main28065 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int[] A = new int[N];
    int l = 1, r = N;
    int idx = 0;

    while (l <= r) {
      if (idx < N) {
        A[idx++] = l++;
      }
      if (idx < N) {
        A[idx++] = r--;
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      sb.append(A[i]).append(' ');
    }
    System.out.print(sb);
  }
}
