package baekjoon.step40;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2637 {

  static class Node {

    int next, count;

    Node(int n, int c) {
      next = n;
      count = c;
    }
  }

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());

    ArrayList<Node>[] graph = new ArrayList[N + 1];
    for (int i = 1; i <= N; i++) {
      graph[i] = new ArrayList<>();
    }

    int[] indegree = new int[N + 1];

    int[][] basic = new int[N + 1][N + 1];

    boolean[] isBasic = new boolean[N + 1];
    Arrays.fill(isBasic, true);

    for (int i = 0; i < M; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int X = Integer.parseInt(st.nextToken());
      int Y = Integer.parseInt(st.nextToken());
      int K = Integer.parseInt(st.nextToken());

      graph[Y].add(new Node(X, K));
      indegree[X]++;
      isBasic[X] = false;
    }

    Queue<Integer> q = new ArrayDeque<>();

    for (int i = 1; i <= N; i++) {
      if (indegree[i] == 0) {
        q.add(i);
      }
    }

    while (!q.isEmpty()) {
      int cur = q.poll();

      for (Node nxt : graph[cur]) {

        if (isBasic[cur]) {
          basic[nxt.next][cur] += nxt.count;
        } else {
          for (int i = 1; i <= N; i++) {
            basic[nxt.next][i] +=
                basic[cur][i] * nxt.count;
          }
        }

        if (--indegree[nxt.next] == 0) {
          q.add(nxt.next);
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= N; i++) {
      if (isBasic[i]) {
        sb.append(i).append(" ")
            .append(basic[N][i]).append('\n');
      }
    }

    System.out.print(sb);
  }
}
