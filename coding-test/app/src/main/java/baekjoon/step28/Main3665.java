package baekjoon.step28;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main3665 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(br.readLine());

    while (T-- > 0) {
      int n = Integer.parseInt(br.readLine());
      int[] last = new int[n];
      int[] indegree = new int[n + 1];
      ArrayList<Integer>[] graph = new ArrayList[n + 1];

      for (int i = 1; i <= n; i++) {
        graph[i] = new ArrayList<>();
      }

      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int i = 0; i < n; i++) {
        last[i] = Integer.parseInt(st.nextToken());
      }

      for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
          int a = last[i];
          int b = last[j];
          graph[a].add(b);
          indegree[b]++;
        }
      }

      int m = Integer.parseInt(br.readLine());
      for (int i = 0; i < m; i++) {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        if (graph[a].contains(b)) {
          graph[a].remove((Integer) b);
          graph[b].add(a);
          indegree[b]--;
          indegree[a]++;
        } else {
          graph[b].remove((Integer) a);
          graph[a].add(b);
          indegree[a]--;
          indegree[b]++;
        }
      }

      Queue<Integer> q = new LinkedList<>();
      for (int i = 1; i <= n; i++) {
        if (indegree[i] == 0) {
          q.add(i);
        }
      }

      ArrayList<Integer> result = new ArrayList<>();
      boolean certain = true;
      boolean impossible = false;

      for (int i = 0; i < n; i++) {
        if (q.isEmpty()) {
          impossible = true;
          break;
        }
        if (q.size() > 1) {
          certain = false;
        }

        int cur = q.poll();
        result.add(cur);

        for (int next : graph[cur]) {
          indegree[next]--;
          if (indegree[next] == 0) {
            q.add(next);
          }
        }
      }

      if (impossible) {
        sb.append("IMPOSSIBLE\n");
      } else if (!certain) {
        sb.append("?\n");
      } else {
        for (int x : result) {
          sb.append(x).append(" ");
        }
        sb.append("\n");
      }
    }

    System.out.print(sb);
  }
}
