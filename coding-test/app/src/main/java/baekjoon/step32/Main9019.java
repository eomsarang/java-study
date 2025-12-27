package baekjoon.step32;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main9019 {

  static final int MAX = 10000;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder out = new StringBuilder();

    int T = Integer.parseInt(br.readLine());

    while (T-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int A = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());

      boolean[] visited = new boolean[MAX];
      int[] parent = new int[MAX];
      char[] how = new char[MAX];

      Queue<Integer> q = new LinkedList<>();
      q.offer(A);
      visited[A] = true;
      parent[A] = -1;

      while (!q.isEmpty()) {
        int cur = q.poll();
        if (cur == B) {
          break;
        }

        int d = (cur * 2) % 10000;
        if (!visited[d]) {
          visited[d] = true;
          parent[d] = cur;
          how[d] = 'D';
          q.offer(d);
        }

        int s = (cur == 0) ? 9999 : cur - 1;
        if (!visited[s]) {
          visited[s] = true;
          parent[s] = cur;
          how[s] = 'S';
          q.offer(s);
        }

        int l = (cur % 1000) * 10 + (cur / 1000);
        if (!visited[l]) {
          visited[l] = true;
          parent[l] = cur;
          how[l] = 'L';
          q.offer(l);
        }

        int r = (cur % 10) * 1000 + (cur / 10);
        if (!visited[r]) {
          visited[r] = true;
          parent[r] = cur;
          how[r] = 'R';
          q.offer(r);
        }
      }

      StringBuilder sb = new StringBuilder();
      int cur = B;
      while (parent[cur] != -1) {
        sb.append(how[cur]);
        cur = parent[cur];
      }
      out.append(sb.reverse()).append('\n');
    }

    System.out.print(out);
  }
}
