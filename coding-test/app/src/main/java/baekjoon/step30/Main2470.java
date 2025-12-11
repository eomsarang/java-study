package baekjoon.step30;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2470 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    long[] arr = new long[n];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Long.parseLong(st.nextToken());
    }

    Arrays.sort(arr);

    int left = 0;
    int right = n - 1;

    long bestSum = Long.MAX_VALUE;
    long ans1 = 0, ans2 = 0;

    while (left < right) {
      long sum = arr[left] + arr[right];

      if (Math.abs(sum) < Math.abs(bestSum)) {
        bestSum = sum;
        ans1 = arr[left];
        ans2 = arr[right];
      }

      if (sum > 0) {
        right--;
      } else {
        left++;
      }
    }

    System.out.println(ans1 + " " + ans2);
  }
}
