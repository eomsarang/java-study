package baekjoon.step49;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main11012 {

  static class Event implements Comparable<Event> {

    int x, y1, y2, type, sign;

    // 점
    Event(int x, int y) {
      this.x = x;
      this.y1 = y;
      this.type = 0;
    }

    // 쿼리
    Event(int x, int y1, int y2, int sign) {
      this.x = x;
      this.y1 = y1;
      this.y2 = y2;
      this.sign = sign;
      this.type = 1;
    }

    public int compareTo(Event o) {
      if (this.x == o.x) {
        return this.type - o.type;
      }
      return this.x - o.x;
    }
  }

  static int[] tree;

  static void update(int i) {
    while (i < tree.length) {
      tree[i]++;
      i += i & -i;
    }
  }

  static int query(int i) {
    int sum = 0;
    while (i > 0) {
      sum += tree[i];
      i -= i & -i;
    }
    return sum;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());

    while (T-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());

      ArrayList<Event> events = new ArrayList<>();

      for (int i = 0; i < n; i++) {
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        events.add(new Event(x, y));
      }

      for (int i = 0; i < m; i++) {
        st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        events.add(new Event(r, b, t, +1));
        events.add(new Event(l - 1, b, t, -1));
      }

      Collections.sort(events);

      tree = new int[100001 + 5]; // y 최대 100000

      long answer = 0;

      for (Event e : events) {
        if (e.type == 0) {
          update(e.y + 1);
        } else {
          int res = query(e.y2 + 1) - query(e.y1);
          answer += (long) e.sign * res;
        }
      }

      sb.append(answer).append("\n");
    }

    System.out.print(sb);
  }
}