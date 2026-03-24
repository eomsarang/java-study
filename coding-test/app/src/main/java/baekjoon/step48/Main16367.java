package baekjoon.step48;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main16367 {

  static int k, n;
  static ArrayList<Integer>[] graph;
  static int[] id, scc;
  static boolean[] finished;
  static Stack<Integer> stack;
  static int idx = 0, sccCnt = 0;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    k = Integer.parseInt(st.nextToken());
    n = Integer.parseInt(st.nextToken());

    graph = new ArrayList[2 * k + 1];
    for (int i = 1; i <= 2 * k; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());

      int[] lit = new int[3];

      for (int j = 0; j < 3; j++) {
        int l = Integer.parseInt(st.nextToken());
        char c = st.nextToken().charAt(0);

        if (c == 'B') {
          lit[j] = l;
        } else {
          lit[j] = -l;
        }
      }

      addClause(lit[0], lit[1]);
      addClause(lit[0], lit[2]);
      addClause(lit[1], lit[2]);
    }

    id = new int[2 * k + 1];
    scc = new int[2 * k + 1];
    finished = new boolean[2 * k + 1];
    stack = new Stack<>();

    for (int i = 1; i <= 2 * k; i++) {
      if (id[i] == 0) {
        dfs(i);
      }
    }

    // check
    for (int i = 1; i <= k; i++) {
      if (scc[i] == scc[i + k]) {
        System.out.println(-1);
        return;
      }
    }

    // assign
    char[] result = new char[k + 1];
    for (int i = 1; i <= k; i++) {
      if (scc[i] < scc[i + k]) {
        result[i] = 'B';
      } else {
        result[i] = 'R';
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= k; i++) {
      sb.append(result[i]);
    }
    System.out.println(sb);
  }

  static void addClause(int a, int b) {
    int A = convert(a);
    int B = convert(b);

    graph[not(A)].add(B);
    graph[not(B)].add(A);
  }

  static int convert(int x) {
    if (x > 0) {
      return x;
    }
    return -x + k;
  }

  static int not(int x) {
    if (x <= k) {
      return x + k;
    }
    return x - k;
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