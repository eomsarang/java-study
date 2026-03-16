package baekjoon.step46;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main28122 {

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    long[] arr = new long[N];
    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < N; i++) {
      arr[i] = Long.parseLong(st.nextToken());
    }

    Arrays.sort(arr);

    int k = 0;

    for (long x : arr) {

      long reach;

      if (k >= 60) {
        reach = Long.MAX_VALUE;
      } else {
        reach = (1L << k) - 1;
      }

      if (x <= reach) {
        k++;
      } else {
        break;
      }
    }

    System.out.println(k);
  }
}
