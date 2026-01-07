package baekjoon.step34;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main4195 {

  static int[] parent;
  static int[] size;

  static int find(int x) {
    if (parent[x] == x) {
      return x;
    }
    return parent[x] = find(parent[x]);
  }

  static int union(int a, int b) {
    int ra = find(a);
    int rb = find(b);

    if (ra != rb) {
      parent[rb] = ra;
      size[ra] += size[rb];
    }
    return size[ra];
  }

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());

    while (T-- > 0) {

      int F = Integer.parseInt(br.readLine());

      parent = new int[2 * F + 1];
      size = new int[2 * F + 1];

      for (int i = 1; i <= 2 * F; i++) {
        parent[i] = i;
        size[i] = 1;
      }

      HashMap<String, Integer> map = new HashMap<>();
      int idx = 1;

      StringTokenizer st;

      for (int i = 0; i < F; i++) {

        st = new StringTokenizer(br.readLine());

        String name1 = st.nextToken();
        String name2 = st.nextToken();

        if (!map.containsKey(name1)) {
          map.put(name1, idx++);
        }
        if (!map.containsKey(name2)) {
          map.put(name2, idx++);
        }

        int a = map.get(name1);
        int b = map.get(name2);

        int result = union(a, b);
        sb.append(result).append('\n');
      }
    }

    System.out.println(sb);
  }
}
