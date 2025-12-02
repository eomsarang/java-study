package baekjoon.step28;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1766 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i <= N; i++) {
      graph.add(new ArrayList<>());
    }

    int[] indegree = new int[N + 1];

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int A = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());

      graph.get(A).add(B);
      indegree[B]++;
    }

    PriorityQueue<Integer> pq = new PriorityQueue<>();

    for (int i = 1; i <= N; i++) {
      if (indegree[i] == 0) {
        pq.add(i);
      }
    }

    StringBuilder sb = new StringBuilder();

    while (!pq.isEmpty()) {
      int cur = pq.poll();
      sb.append(cur).append(' ');

      for (int next : graph.get(cur)) {
        indegree[next]--;
        if (indegree[next] == 0) {
          pq.add(next);
        }
      }
    }

    System.out.println(sb);
  }
}
