package baekjoon.step29;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Main13549 {

  static final int MAX = 100000;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int K = sc.nextInt();

    int[] dist = new int[MAX + 1];
    Arrays.fill(dist, -1);

    Deque<Integer> dq = new ArrayDeque<>();
    dq.add(N);
    dist[N] = 0;

    while (!dq.isEmpty()) {
      int x = dq.poll();

      if (x == K) {
        System.out.println(dist[x]);
        return;
      }

      int nx = x * 2;
      if (nx <= MAX && dist[nx] == -1) {
        dist[nx] = dist[x];
        dq.addFirst(nx);
      }

      int[] moves = {x - 1, x + 1};
      for (int next : moves) {
        if (0 <= next && next <= MAX && dist[next] == -1) {
          dist[next] = dist[x] + 1;
          dq.addLast(next);
        }
      }
    }
  }
}
