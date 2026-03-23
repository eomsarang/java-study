package baekjoon.step48;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main3648 {

  static int n, m;
  static ArrayList<Integer>[] graph;
  static int[] id, scc;
  static boolean[] finished;
  static Stack<Integer> stack;
  static int idx, sccCnt;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;

    StringBuilder sb = new StringBuilder();

    while ((line = br.readLine()) != null) {
      if (line.isEmpty()) {
        continue;
      }

      StringTokenizer st = new StringTokenizer(line);
      n = Integer.parseInt(st.nextToken());
      m = Integer.parseInt(st.nextToken());

      graph = new ArrayList[2 * n + 1];
      for (int i = 1; i <= 2 * n; i++) {
        graph[i] = new ArrayList<>();
      }

      for (int i = 0; i < m; i++) {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int A = convert(a);
        int B = convert(b);

        graph[not(A)].add(B);
        graph[not(B)].add(A);
      }

      graph[not(convert(1))].add(convert(1));

      id = new int[2 * n + 1];
      scc = new int[2 * n + 1];
      finished = new boolean[2 * n + 1];
      stack = new Stack<>();
      idx = 0;
      sccCnt = 0;

      for (int i = 1; i <= 2 * n; i++) {
        if (id[i] == 0) {
          dfs(i);
        }
      }

      boolean ok = true;
      for (int i = 1; i <= n; i++) {
        if (scc[i] == scc[i + n]) {
          ok = false;
          break;
        }
      }

      sb.append(ok ? "yes\n" : "no\n");
    }

    System.out.print(sb);
  }

  static int convert(int x) {
    if (x > 0) {
      return x;
    }
    return -x + n;
  }

  static int not(int x) {
    if (x <= n) {
      return x + n;
    }
    return x - n;
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
