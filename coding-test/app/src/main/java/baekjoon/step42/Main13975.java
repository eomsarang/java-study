package baekjoon.step42;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main13975 {

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(
        new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());

    while (T-- > 0) {

      int K = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine());

      PriorityQueue<Long> pq = new PriorityQueue<>();

      for (int i = 0; i < K; i++) {
        pq.add(Long.parseLong(st.nextToken()));
      }

      long answer = 0;

      while (pq.size() > 1) {
        long a = pq.poll();
        long b = pq.poll();

        long sum = a + b;
        answer += sum;
        pq.add(sum);
      }

      sb.append(answer).append('\n');
    }

    System.out.print(sb);
  }
}
