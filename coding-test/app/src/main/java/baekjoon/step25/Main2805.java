package baekjoon.step25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2805 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    long M = Long.parseLong(st.nextToken());

    long[] trees = new long[N];
    long max = 0;

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      trees[i] = Long.parseLong(st.nextToken());
      if (trees[i] > max) {
        max = trees[i];
      }
    }

    long left = 0;
    long right = max;
    long answer = 0;

    while (left <= right) {
      long mid = (left + right) / 2;
      long total = 0;

      for (long tree : trees) {
        if (tree > mid) {
          total += (tree - mid);
        }
      }

      if (total >= M) {
        answer = mid;
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    System.out.println(answer);
  }
}
