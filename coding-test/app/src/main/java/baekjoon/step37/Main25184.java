package baekjoon.step37;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main25184 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int k = N / 2;
    StringBuilder sb = new StringBuilder();

    int left = 1;
    int right = k + 1;

    while (left <= k || right <= N) {
      if (right <= N) {
        sb.append(right).append(' ');
        right++;
      }
      if (left <= k) {
        sb.append(left).append(' ');
        left++;
      }
    }

    System.out.println(sb.toString().trim());
  }
}
