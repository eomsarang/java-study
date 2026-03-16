package baekjoon.step46;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main21162 {

  static int N, K;
  static int[] A;

  static int get(int split, int idx) {

    if (idx < split) {
      return A[split - 1 - idx];
    }
    return A[N - 1 - (idx - split)];
  }

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    A = new int[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }

    Integer[] split = new Integer[N - 1];

    for (int i = 1; i < N; i++) {
      split[i - 1] = i;
    }

    Arrays.sort(split, (a, b) -> {

      for (int i = 0; i < N; i++) {

        int x = get(a, i);
        int y = get(b, i);

        if (x != y) {
          return x - y;
        }
      }

      return 0;
    });

    int s = split[K - 1];

    StringBuilder sb = new StringBuilder();

    for (int i = s - 1; i >= 0; i--) {
      sb.append(A[i]).append(' ');
    }

    for (int i = N - 1; i >= s; i--) {
      sb.append(A[i]).append(' ');
    }

    System.out.println(sb);
  }
}
