package baekjoon.step42;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main28340 {

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int T = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    while (T-- > 0) {

      st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int K = Integer.parseInt(st.nextToken());

      st = new StringTokenizer(br.readLine());

      PriorityQueue<Long> pq = new PriorityQueue<>();

      for (int i = 0; i < N; i++) {
        long c = Long.parseLong(st.nextToken());
        if (c > 0) {
          pq.add(c);
        }
      }

      if (pq.isEmpty()) {
        sb.append(0).append('\n');
        continue;
      }

      int size = pq.size();

      if (K > 1) {
        int need = (K - 1 - (size - 1) % (K - 1)) % (K - 1);
        for (int i = 0; i < need; i++) {
          pq.add(0L);
        }
      }

      long answer = 0;

      while (pq.size() > 1) {
        long sum = 0;
        for (int i = 0; i < K; i++) {
          sum += pq.poll();
        }
        answer += sum;
        pq.add(sum);
      }

      sb.append(answer).append('\n');
    }

    System.out.print(sb);
  }
}
