package baekjoon.step28;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2252 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    ArrayList<Integer>[] graph = new ArrayList[N + 1];
    int[] indegree = new int[N + 1];

    for (int i = 1; i <= N; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int A = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());
      graph[A].add(B);
      indegree[B]++;
    }

    Queue<Integer> q = new LinkedList<>();
    StringBuilder sb = new StringBuilder();

    for (int i = 1; i <= N; i++) {
      if (indegree[i] == 0) {
        q.add(i);
      }
    }

    while (!q.isEmpty()) {
      int cur = q.poll();
      sb.append(cur).append(" ");

      for (int next : graph[cur]) {
        indegree[next]--;
        if (indegree[next] == 0) {
          q.add(next);
        }
      }
    }

    System.out.println(sb);
  }
}
