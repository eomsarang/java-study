package baekjoon.step44;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main16975 {

  static int N;
  static long[] tree;

  static void update(int i, long diff) {
    while (i <= N) {
      tree[i] += diff;
      i += (i & -i);
    }
  }

  static long sum(int i) {
    long s = 0;
    while (i > 0) {
      s += tree[i];
      i -= (i & -i);
    }
    return s;
  }

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());

    tree = new long[N + 2];

    st = new StringTokenizer(br.readLine());
    long prev = 0;

    for (int i = 1; i <= N; i++) {
      long cur = Long.parseLong(st.nextToken());
      update(i, cur - prev);
      prev = cur;
    }

    int M = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    while (M-- > 0) {

      st = new StringTokenizer(br.readLine());
      int type = Integer.parseInt(st.nextToken());

      if (type == 1) {

        int i = Integer.parseInt(st.nextToken());
        int j = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        update(i, k);
        update(j + 1, -k);

      } else {

        int x = Integer.parseInt(st.nextToken());
        sb.append(sum(x)).append('\n');
      }
    }

    System.out.print(sb);
  }
}
