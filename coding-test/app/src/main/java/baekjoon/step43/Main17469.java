package baekjoon.step43;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main17469 {

  static class Query {

    int type, a;

    Query(int t, int a) {
      this.type = t;
      this.a = a;
    }
  }

  static int[] parentUF;
  static int[] parent;
  static HashMap<Integer, Integer>[] colorMap;

  static int find(int x) {
    if (parentUF[x] == x) {
      return x;
    }
    return parentUF[x] = find(parentUF[x]);
  }

  static void union(int a, int b) {
    a = find(a);
    b = find(b);
    if (a == b) {
      return;
    }

    if (colorMap[a].size() < colorMap[b].size()) {
      int tmp = a;
      a = b;
      b = tmp;
    }

    parentUF[b] = a;

    for (Map.Entry<Integer, Integer> e : colorMap[b].entrySet()) {
      colorMap[a].merge(e.getKey(), e.getValue(), Integer::sum);
    }
    colorMap[b].clear();
  }

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int Q = Integer.parseInt(st.nextToken());

    parent = new int[N + 1];

    for (int i = 2; i <= N; i++) {
      parent[i] = Integer.parseInt(br.readLine());
    }

    int[] color = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      color[i] = Integer.parseInt(br.readLine());
    }

    int total = N + Q - 1;
    Query[] queries = new Query[total];
    boolean[] removed = new boolean[N + 1];

    for (int i = 0; i < total; i++) {
      st = new StringTokenizer(br.readLine());
      int t = Integer.parseInt(st.nextToken());
      int a = Integer.parseInt(st.nextToken());

      queries[i] = new Query(t, a);
      if (t == 1) {
        removed[a] = true;
      }
    }

    parentUF = new int[N + 1];
    colorMap = new HashMap[N + 1];

    for (int i = 1; i <= N; i++) {
      parentUF[i] = i;
      colorMap[i] = new HashMap<>();
      colorMap[i].put(color[i], 1);
    }

    for (int i = 2; i <= N; i++) {
      if (!removed[i]) {
        union(i, parent[i]);
      }
    }

    ArrayList<Integer> ans = new ArrayList<>();

    for (int i = total - 1; i >= 0; i--) {
      Query q = queries[i];

      if (q.type == 1) {
        union(q.a, parent[q.a]);
      } else {
        int root = find(q.a);
        ans.add(colorMap[root].size());
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = ans.size() - 1; i >= 0; i--) {
      sb.append(ans.get(i)).append('\n');
    }

    System.out.print(sb);
  }
}
