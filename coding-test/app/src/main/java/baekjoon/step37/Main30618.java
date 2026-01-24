package baekjoon.step37;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main30618 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int[] ans = new int[N];
    int l = 0, r = N - 1;
    boolean left = true;

    for (int x = N; x >= 1; x--) {
      if (left) {
        ans[l++] = x;
      } else {
        ans[r--] = x;
      }
      left = !left;
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      sb.append(ans[i]).append(' ');
    }
    System.out.print(sb);
  }
}
