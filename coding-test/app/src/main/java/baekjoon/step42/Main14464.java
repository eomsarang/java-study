package baekjoon.step42;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main14464 {

  static class Cow {

    int a, b;

    Cow(int a, int b) {
      this.a = a;
      this.b = b;
    }
  }

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int C = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());

    int[] chicken = new int[C];
    for (int i = 0; i < C; i++) {
      chicken[i] = Integer.parseInt(br.readLine());
    }

    Cow[] cows = new Cow[N];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      cows[i] = new Cow(
          Integer.parseInt(st.nextToken()),
          Integer.parseInt(st.nextToken())
      );
    }

    Arrays.sort(chicken);
    Arrays.sort(cows, Comparator.comparingInt(o -> o.a));

    PriorityQueue<Cow> pq =
        new PriorityQueue<>(Comparator.comparingInt(o -> o.b));

    int idx = 0;
    int answer = 0;

    for (int t : chicken) {

      while (idx < N && cows[idx].a <= t) {
        pq.add(cows[idx++]);
      }

      while (!pq.isEmpty() && pq.peek().b < t) {
        pq.poll();
      }

      if (!pq.isEmpty()) {
        pq.poll();
        answer++;
      }
    }

    System.out.println(answer);
  }
}
