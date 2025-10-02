package baekjoon.step20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14888 {

  static int N;
  static int[] nums;
  static int[] ops = new int[4];
  static int maxVal = Integer.MIN_VALUE;
  static int minVal = Integer.MAX_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine().trim());
    nums = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < 4; i++) {
      ops[i] = Integer.parseInt(st.nextToken());
    }

    dfs(nums[0], 1);

    System.out.println(maxVal);
    System.out.println(minVal);
  }

  static void dfs(int current, int idx) {
    if (idx == N) {
      maxVal = Math.max(maxVal, current);
      minVal = Math.min(minVal, current);
      return;
    }

    for (int i = 0; i < 4; i++) {
      if (ops[i] > 0) {
        ops[i]--;

        int next = 0;
        switch (i) {
          case 0:
            next = current + nums[idx];
            break;
          case 1:
            next = current - nums[idx];
            break;
          case 2:
            next = current * nums[idx];
            break;
          case 3:
            if (current < 0) {
              next = -(Math.abs(current) / nums[idx]);
            } else {
              next = current / nums[idx];
            }
            break;
        }

        dfs(next, idx + 1);
        ops[i]++;
      }
    }
  }
}
