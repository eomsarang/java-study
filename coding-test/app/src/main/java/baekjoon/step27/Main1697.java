package baekjoon.step27;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1697 {

  static final int MAX = 100000;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    boolean[] visited = new boolean[MAX + 1];
    int[] dist = new int[MAX + 1];

    Queue<Integer> queue = new LinkedList<>();
    queue.add(N);
    visited[N] = true;
    dist[N] = 0;

    while (!queue.isEmpty()) {
      int now = queue.poll();

      if (now == K) {
        System.out.println(dist[now]);
        return;
      }

      int[] next = {now - 1, now + 1, now * 2};

      for (int nx : next) {
        if (nx >= 0 && nx <= MAX && !visited[nx]) {
          visited[nx] = true;
          dist[nx] = dist[now] + 1;
          queue.add(nx);
        }
      }
    }
  }
}
