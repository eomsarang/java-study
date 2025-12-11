package baekjoon.step30;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1806 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int S = Integer.parseInt(st.nextToken());

    int[] arr = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int left = 0, right = 0;
    int sum = 0;
    int minLen = Integer.MAX_VALUE;

    while (true) {
      if (sum >= S) {
        minLen = Math.min(minLen, right - left);
        sum -= arr[left++];
      } else if (right < N) {
        sum += arr[right++];
      } else {
        break;
      }
    }

    if (minLen == Integer.MAX_VALUE) {
      System.out.println(0);
    } else {
      System.out.println(minLen);
    }
  }
}
