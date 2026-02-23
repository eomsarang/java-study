package baekjoon.step43;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main13306 {

  static class Query {

    int type;
    int a, b;

    Query(int t, int a, int b) {
      this.type = t;
      this.a = a;
      this.b = b;
    }
  }

  static int[] parentUF;

  static int find(int x) {
    if (parentUF[x] == x) {
      return x;
    }
    return parentUF[x] = find(parentUF[x]);
  }

  static void union(int a, int b) {
    a = find(a);
    b = find(b);
    if (a != b) {
      parentUF[b] = a;
    }
  }

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int Q = Integer.parseInt(st.nextToken());

    int[] parent = new int[N + 1];

    for (int i = 2; i <= N; i++) {
      parent[i] = Integer.parseInt(br.readLine());
    }

    int total = (N - 1) + Q;
    Query[] queries = new Query[total];
    boolean[] removed = new boolean[N + 1];

    int idx = 0;
    for (int i = 0; i < total; i++) {
      st = new StringTokenizer(br.readLine());
      int type = Integer.parseInt(st.nextToken());

      if (type == 0) {
        int b = Integer.parseInt(st.nextToken());
        queries[idx++] = new Query(0, b, 0);
        removed[b] = true;
      } else {
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        queries[idx++] = new Query(1, c, d);
      }
    }

    parentUF = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      parentUF[i] = i;
    }

    for (int i = 2; i <= N; i++) {
      if (!removed[i]) {
        union(i, parent[i]);
      }
    }

    ArrayList<String> answer = new ArrayList<>();

    for (int i = total - 1; i >= 0; i--) {
      Query q = queries[i];

      if (q.type == 0) {
        int b = q.a;
        union(b, parent[b]);
      } else {
        if (find(q.a) == find(q.b)) {
          answer.add("YES");
        } else {
          answer.add("NO");
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = answer.size() - 1; i >= 0; i--) {
      sb.append(answer.get(i)).append('\n');
    }

    System.out.print(sb);
  }
}
