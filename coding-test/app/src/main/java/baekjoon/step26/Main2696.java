package baekjoon.step26;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main2696 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());

    while (T-- > 0) {
      int M = Integer.parseInt(br.readLine());

      PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
      PriorityQueue<Integer> right = new PriorityQueue<>();

      List<Integer> result = new ArrayList<>();

      int count = 0;
      while (count < M) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
          int x = Integer.parseInt(st.nextToken());
          count++;

          if (left.isEmpty() || x <= left.peek()) {
            left.offer(x);
          } else {
            right.offer(x);
          }

          if (left.size() < right.size()) {
            left.offer(right.poll());
          } else if (left.size() > right.size() + 1) {
            right.offer(left.poll());
          }

          if (count % 2 == 1) {
            result.add(left.peek());
          }
        }
      }

      sb.append(result.size()).append("\n");

      for (int i = 0; i < result.size(); i++) {
        sb.append(result.get(i)).append(" ");
        if ((i + 1) % 10 == 0) {
          sb.append("\n");
        }
      }
      sb.append("\n");
    }

    System.out.println(sb);
  }
}
