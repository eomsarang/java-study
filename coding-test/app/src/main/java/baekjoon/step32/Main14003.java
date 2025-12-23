package baekjoon.step32;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14003 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[] A = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }

    int[] tail = new int[N];
    int[] tailIdx = new int[N];
    int[] prev = new int[N];

    int len = 0;

    for (int i = 0; i < N; i++) {
      int x = A[i];

      int l = 0, r = len;
      while (l < r) {
        int mid = (l + r) / 2;
        if (tail[mid] < x) {
          l = mid + 1;
        } else {
          r = mid;
        }
      }

      tail[l] = x;
      tailIdx[l] = i;
      prev[i] = (l > 0) ? tailIdx[l - 1] : -1;

      if (l == len) {
        len++;
      }
    }

    int idx = tailIdx[len - 1];
    int[] result = new int[len];

    for (int i = len - 1; i >= 0; i--) {
      result[i] = A[idx];
      idx = prev[idx];
    }

    StringBuilder sb = new StringBuilder();
    sb.append(len).append('\n');
    for (int x : result) {
      sb.append(x).append(' ');
    }

    System.out.println(sb.toString().trim());
  }
}
