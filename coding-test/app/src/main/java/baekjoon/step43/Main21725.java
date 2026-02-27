package baekjoon.step43;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main21725 {

  static int[] parent, size;
  static long[] groupCost, offset, personal;

  static int find(int x) {
    if (parent[x] == x) {
      return x;
    }
    int p = parent[x];
    parent[x] = find(p);
    offset[x] += offset[p];
    return parent[x];
  }

  static void union(int a, int b) {
    int ra = find(a);
    int rb = find(b);
    if (ra == rb) {
      return;
    }

    if (size[ra] < size[rb]) {
      int t = ra;
      ra = rb;
      rb = t;
    }

    parent[rb] = ra;

    offset[rb] += groupCost[ra] - groupCost[rb];

    size[ra] += size[rb];
  }

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    parent = new int[n + 1];
    size = new int[n + 1];
    groupCost = new long[n + 1];
    offset = new long[n + 1];
    personal = new long[n + 1];

    for (int i = 1; i <= n; i++) {
      parent[i] = i;
      size[i] = 1;
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int type = Integer.parseInt(st.nextToken());

      if (type == 1) {
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        union(x, y);
      } else {
        int x = Integer.parseInt(st.nextToken());
        long c = Long.parseLong(st.nextToken());

        int r = find(x);
        long share = c / size[r];

        groupCost[r] += share;
        personal[x] += c;
      }
    }

    long[] balance = new long[n + 1];

    for (int i = 1; i <= n; i++) {
      int r = find(i);
      long mustPay = groupCost[r] + offset[i];
      balance[i] = personal[i] - mustPay;
    }

    ArrayDeque<long[]> debt = new ArrayDeque<>();
    ArrayDeque<long[]> credit = new ArrayDeque<>();

    for (int i = 1; i <= n; i++) {
      if (balance[i] < 0) {
        debt.add(new long[]{i, -balance[i]});
      } else if (balance[i] > 0) {
        credit.add(new long[]{i, balance[i]});
      }
    }

    StringBuilder sb = new StringBuilder();
    ArrayList<String> ans = new ArrayList<>();

    while (!debt.isEmpty() && !credit.isEmpty()) {
      long[] d = debt.poll();
      long[] c = credit.poll();

      long give = Math.min(d[1], c[1]);

      ans.add(d[0] + " " + c[0] + " " + give);

      d[1] -= give;
      c[1] -= give;

      if (d[1] > 0) {
        debt.addFirst(d);
      }
      if (c[1] > 0) {
        credit.addFirst(c);
      }
    }

    if (!debt.isEmpty() || !credit.isEmpty()) {
      System.out.println(-1);
      return;
    }

    sb.append(ans.size()).append('\n');
    for (String s : ans) {
      sb.append(s).append('\n');
    }

    System.out.print(sb);
  }
}
