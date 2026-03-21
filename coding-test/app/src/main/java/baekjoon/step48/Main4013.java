package baekjoon.step48;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main4013 {

  static int N, M;
  static ArrayList<Integer>[] graph;
  static int[] money;

  static int[] id, sccId;
  static boolean[] finished;
  static Stack<Integer> stack;
  static int idx = 0, sccCnt = 0;

  static int[] sccMoney;
  static ArrayList<Integer>[] sccGraph;
  static int[] indegree;

  static boolean[] isRestaurant;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    graph = new ArrayList[N + 1];
    for (int i = 1; i <= N; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      graph[u].add(v);
    }

    money = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      money[i] = Integer.parseInt(br.readLine());
    }

    st = new StringTokenizer(br.readLine());
    int S = Integer.parseInt(st.nextToken());
    int P = Integer.parseInt(st.nextToken());

    isRestaurant = new boolean[N + 1];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < P; i++) {
      int r = Integer.parseInt(st.nextToken());
      isRestaurant[r] = true;
    }

    id = new int[N + 1];
    sccId = new int[N + 1];
    finished = new boolean[N + 1];
    stack = new Stack<>();

    for (int i = 1; i <= N; i++) {
      if (id[i] == 0) {
        dfs(i);
      }
    }

    sccMoney = new int[sccCnt];
    for (int i = 1; i <= N; i++) {
      sccMoney[sccId[i]] += money[i];
    }

    sccGraph = new ArrayList[sccCnt];
    indegree = new int[sccCnt];
    for (int i = 0; i < sccCnt; i++) {
      sccGraph[i] = new ArrayList<>();
    }

    for (int i = 1; i <= N; i++) {
      for (int next : graph[i]) {
        if (sccId[i] != sccId[next]) {
          sccGraph[sccId[i]].add(sccId[next]);
          indegree[sccId[next]]++;
        }
      }
    }

    boolean[] sccRestaurant = new boolean[sccCnt];
    for (int i = 1; i <= N; i++) {
      if (isRestaurant[i]) {
        sccRestaurant[sccId[i]] = true;
      }
    }

    int[] dp = new int[sccCnt];
    Arrays.fill(dp, -1);

    Queue<Integer> q = new ArrayDeque<>();

    int start = sccId[S];
    dp[start] = sccMoney[start];

    Queue<Integer> topo = new ArrayDeque<>();
    for (int i = 0; i < sccCnt; i++) {
      if (indegree[i] == 0) {
        topo.offer(i);
      }
    }

    while (!topo.isEmpty()) {
      int cur = topo.poll();

      for (int next : sccGraph[cur]) {
        if (dp[cur] != -1) {
          dp[next] = Math.max(dp[next], dp[cur] + sccMoney[next]);
        }
        if (--indegree[next] == 0) {
          topo.offer(next);
        }
      }
    }

    int answer = 0;
    for (int i = 0; i < sccCnt; i++) {
      if (sccRestaurant[i] && dp[i] != -1) {
        answer = Math.max(answer, dp[i]);
      }
    }

    System.out.println(answer);
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
        int node = stack.pop();
        finished[node] = true;
        sccId[node] = sccCnt;
        if (node == x) {
          break;
        }
      }
      sccCnt++;
    }

    return parent;
  }
}
