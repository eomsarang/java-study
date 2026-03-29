package baekjoon.step49;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.StringTokenizer;

public class Main7626 {

  static class Event implements Comparable<Event> {

    int x, y1, y2, type;

    Event(int x, int y1, int y2, int type) {
      this.x = x;
      this.y1 = y1;
      this.y2 = y2;
      this.type = type;
    }

    public int compareTo(Event o) {
      return this.x - o.x;
    }
  }

  static int[] count;
  static long[] length;
  static int[] ys;

  static void update(int node, int start, int end, int l, int r, int val) {
    if (r < start || end < l) {
      return;
    }

    if (l <= start && end <= r) {
      count[node] += val;
    } else {
      int mid = (start + end) / 2;
      update(node * 2, start, mid, l, r, val);
      update(node * 2 + 1, mid + 1, end, l, r, val);
    }

    if (count[node] > 0) {
      length[node] = ys[end + 1] - ys[start];
    } else {
      if (start == end) {
        length[node] = 0;
      } else {
        length[node] = length[node * 2] + length[node * 2 + 1];
      }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    ArrayList<Event> events = new ArrayList<>();
    ArrayList<Integer> yList = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int x1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());

      events.add(new Event(x1, y1, y2, 1));
      events.add(new Event(x2, y1, y2, -1));

      yList.add(y1);
      yList.add(y2);
    }

    Collections.sort(yList);
    yList = new ArrayList<>(new LinkedHashSet<>(yList));

    ys = new int[yList.size()];
    for (int i = 0; i < yList.size(); i++) {
      ys[i] = yList.get(i);
    }

    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < ys.length; i++) {
      map.put(ys[i], i);
    }

    for (Event e : events) {
      e.y1 = map.get(e.y1);
      e.y2 = map.get(e.y2) - 1;
    }

    Collections.sort(events);

    int size = ys.length;
    count = new int[size * 4];
    length = new long[size * 4];

    long area = 0;
    int prevX = events.get(0).x;

    for (Event e : events) {
      int curX = e.x;
      long dx = curX - prevX;

      area += dx * length[1];

      update(1, 0, size - 2, e.y1, e.y2, e.type);

      prevX = curX;
    }

    System.out.println(area);
  }
}