package baekjoon.step26;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1202 {

  static class Jewel {

    int m, v;

    Jewel(int m, int v) {
      this.m = m;
      this.v = v;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    Jewel[] jewels = new Jewel[N];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int m = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      jewels[i] = new Jewel(m, v);
    }

    Arrays.sort(jewels, (a, b) -> a.m - b.m);

    int[] bags = new int[K];
    for (int i = 0; i < K; i++) {
      bags[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(bags);

    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

    long answer = 0;
    int jewelIdx = 0;

    for (int c : bags) {

      while (jewelIdx < N && jewels[jewelIdx].m <= c) {
        pq.add(jewels[jewelIdx].v);
        jewelIdx++;
      }

      if (!pq.isEmpty()) {
        answer += pq.poll();
      }
    }

    System.out.println(answer);
  }
}
