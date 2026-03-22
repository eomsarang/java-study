package baekjoon.step48;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main11281 {

  static int N, M;
  static ArrayList<Integer>[] graph;
  static int[] id, scc;
  static boolean[] finished;
  static Stack<Integer> stack;
  static int idx = 0, sccCnt = 0;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    graph = new ArrayList[2 * N + 1];
    for (int i = 1; i <= 2 * N; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      int A = convert(a);
      int B = convert(b);

      graph[not(A)].add(B);
      graph[not(B)].add(A);
    }

    id = new int[2 * N + 1];
    scc = new int[2 * N + 1];
    finished = new boolean[2 * N + 1];
    stack = new Stack<>();

    for (int i = 1; i <= 2 * N; i++) {
      if (id[i] == 0) {
        dfs(i);
      }
    }

    for (int i = 1; i <= N; i++) {
      if (scc[i] == scc[i + N]) {
        System.out.println(0);
        return;
      }
    }

    int[] result = new int[N + 1];

    for (int i = 1; i <= N; i++) {
      if (scc[i] < scc[i + N]) {
        result[i] = 1;
      } else {
        result[i] = 0;
      }
    }

    StringBuilder sb = new StringBuilder();
    sb.append(1).append("\n");
    for (int i = 1; i <= N; i++) {
      sb.append(result[i]).append(" ");
    }

    System.out.println(sb);
  }

  static int convert(int x) {
    if (x > 0) {
      return x;
    }
    return -x + N;
  }

  static int not(int x) {
    if (x <= N) {
      return x + N;
    }
    return x - N;
  }

  static int dfs(int x) {
    id[x] = ++idx;
    stack.push(x);

    int parent = id[x];

    for (int next : graph[x]) {
      if (id[next] == 0) {
        parent = Math.min(parent, dfs(next));
      } else if (!finished[next]) {
        parent = Math.min(parent, id[next]);
      }
    }

    if (parent == id[x]) {
      while (true) {
        int t = stack.pop();
        finished[t] = true;
        scc[t] = sccCnt;
        if (t == x) {
          break;
        }
      }
      sccCnt++;
    }

    return parent;
  }
}
