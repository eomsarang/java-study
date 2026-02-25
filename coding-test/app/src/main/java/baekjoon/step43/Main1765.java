package baekjoon.step43;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main1765 {

  static int[] parent;
  static int[] enemy;

  static int find(int x) {
    if (parent[x] == x) {
      return x;
    }
    return parent[x] = find(parent[x]);
  }

  static void union(int a, int b) {
    a = find(a);
    b = find(b);
    if (a == b) {
      return;
    }
    parent[b] = a;
  }

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int m = Integer.parseInt(br.readLine());

    parent = new int[n + 1];
    enemy = new int[n + 1];

    for (int i = 1; i <= n; i++) {
      parent[i] = i;
      enemy[i] = 0;
    }

    while (m-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      char type = st.nextToken().charAt(0);
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      if (type == 'F') {
        union(a, b);
      } else {
        int ea = enemy[a];
        int eb = enemy[b];

        if (ea != 0) {
          union(ea, b);
        }

        if (eb != 0) {
          union(eb, a);
        }

        enemy[a] = b;
        enemy[b] = a;
      }
    }

    HashSet<Integer> set = new HashSet<>();
    for (int i = 1; i <= n; i++) {
      set.add(find(i));
    }

    System.out.println(set.size());
  }
}
