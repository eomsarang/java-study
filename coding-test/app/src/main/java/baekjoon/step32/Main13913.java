package baekjoon.step32;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main13913 {

  static final int MAX = 100000;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    boolean[] visited = new boolean[MAX + 1];
    int[] parent = new int[MAX + 1];
    int[] dist = new int[MAX + 1];

    Queue<Integer> q = new LinkedList<>();
    q.offer(N);
    visited[N] = true;
    parent[N] = -1;

    while (!q.isEmpty()) {
      int cur = q.poll();

      if (cur == K) {
        break;
      }

      int[] nexts = {cur - 1, cur + 1, cur * 2};
      for (int next : nexts) {
        if (next < 0 || next > MAX) {
          continue;
        }
        if (visited[next]) {
          continue;
        }

        visited[next] = true;
        parent[next] = cur;
        dist[next] = dist[cur] + 1;
        q.offer(next);
      }
    }

    System.out.println(dist[K]);

    Stack<Integer> stack = new Stack<>();
    int cur = K;
    while (cur != -1) {
      stack.push(cur);
      cur = parent[cur];
    }

    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append(stack.pop()).append(" ");
    }
    System.out.println(sb.toString().trim());
  }
}
