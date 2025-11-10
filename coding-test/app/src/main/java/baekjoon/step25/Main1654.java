package baekjoon.step25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1654 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int K = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());

    long[] lines = new long[K];
    long max = 0;

    for (int i = 0; i < K; i++) {
      lines[i] = Long.parseLong(br.readLine());
      if (lines[i] > max) {
        max = lines[i];
      }
    }

    long left = 1;
    long right = max;
    long answer = 0;

    while (left <= right) {
      long mid = (left + right) / 2;
      long count = 0;

      for (long line : lines) {
        count += line / mid;
      }

      if (count >= N) {
        answer = mid;
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    System.out.println(answer);
  }
}
