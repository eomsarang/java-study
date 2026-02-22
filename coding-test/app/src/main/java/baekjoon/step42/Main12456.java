package baekjoon.step42;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main12456 {

  static class Coffee {

    long c, t;
    long s;

    Coffee(long c, long t, long s) {
      this.c = c;
      this.t = t;
      this.s = s;
    }
  }

  static class Node {

    long s, cnt;

    Node(long s, long cnt) {
      this.s = s;
      this.cnt = cnt;
    }
  }

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder out = new StringBuilder();

    int T = Integer.parseInt(br.readLine());

    for (int tc = 1; tc <= T; tc++) {

      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      long K = Long.parseLong(st.nextToken());

      Coffee[] arr = new Coffee[N];

      for (int i = 0; i < N; i++) {
        st = new StringTokenizer(br.readLine());
        long c = Long.parseLong(st.nextToken());
        long t = Long.parseLong(st.nextToken());
        long s = Long.parseLong(st.nextToken());
        arr[i] = new Coffee(c, t, s);
      }

      Arrays.sort(arr, Comparator.comparingLong(o -> o.t));

      PriorityQueue<Node> pq =
          new PriorityQueue<>(Comparator.comparingLong(o -> o.s));

      long total = 0;
      long answer = 0;

      for (Coffee cf : arr) {

        pq.add(new Node(cf.s, cf.c));
        total += cf.c;
        answer += cf.c * cf.s;

        long limit = Math.min(K, cf.t);

        while (total > limit) {
          Node cur = pq.poll();
          long remove = Math.min(cur.cnt, total - limit);

          total -= remove;
          answer -= remove * cur.s;
          cur.cnt -= remove;

          if (cur.cnt > 0) {
            pq.add(cur);
          }
        }
      }

      out.append("Case #")
          .append(tc)
          .append(": ")
          .append(answer)
          .append('\n');
    }

    System.out.print(out);
  }
}
