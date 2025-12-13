package baekjoon.step30;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main1450 {

  static int N;
  static long C;
  static long[] arr;
  static ArrayList<Long> left = new ArrayList<>();
  static ArrayList<Long> right = new ArrayList<>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    C = Long.parseLong(st.nextToken());

    arr = new long[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Long.parseLong(st.nextToken());
    }

    dfs(0, N / 2, 0, left);
    dfs(N / 2, N, 0, right);

    Collections.sort(right);

    long answer = 0;

    for (long l : left) {
      if (l > C) {
        continue;
      }
      long remain = C - l;
      answer += upperBound(right, remain);
    }

    System.out.println(answer);
  }


  static void dfs(int idx, int end, long sum, ArrayList<Long> list) {
    if (sum > C) {
      return;
    }
    if (idx == end) {
      list.add(sum);
      return;
    }
    dfs(idx + 1, end, sum, list);
    dfs(idx + 1, end, sum + arr[idx], list);
  }

  static int upperBound(ArrayList<Long> list, long target) {
    int left = 0, right = list.size();
    while (left < right) {
      int mid = (left + right) / 2;
      if (list.get(mid) <= target) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return left;
  }
}
