package baekjoon.step27;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main16928 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[] move = new int[101];
    boolean[] visited = new boolean[101];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      move[x] = y;
    }
    
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      move[u] = v;
    }

    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{1, 0});
    visited[1] = true;

    while (!q.isEmpty()) {
      int[] cur = q.poll();
      int pos = cur[0];
      int cnt = cur[1];

      if (pos == 100) {
        System.out.println(cnt);
        return;
      }

      for (int dice = 1; dice <= 6; dice++) {
        int next = pos + dice;
        if (next > 100) {
          continue;
        }

        if (move[next] != 0) {
          next = move[next];
        }

        if (!visited[next]) {
          visited[next] = true;
          q.add(new int[]{next, cnt + 1});
        }
      }
    }
  }
}
