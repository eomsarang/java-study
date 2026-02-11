package baekjoon.step39;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2162 {

  static class Line {

    long x1, y1, x2, y2;

    Line(long x1, long y1, long x2, long y2) {
      this.x1 = x1;
      this.y1 = y1;
      this.x2 = x2;
      this.y2 = y2;
    }
  }

  static int[] parent;
  static int[] size;

  static int find(int x) {
    if (parent[x] == x) {
      return x;
    }
    return parent[x] = find(parent[x]);
  }

  static void union(int a, int b) {
    int pa = find(a);
    int pb = find(b);

    if (pa == pb) {
      return;
    }

    if (size[pa] < size[pb]) {
      parent[pa] = pb;
      size[pb] += size[pa];
    } else {
      parent[pb] = pa;
      size[pa] += size[pb];
    }
  }

  static long ccw(long ax, long ay, long bx, long by, long cx, long cy) {
    return (bx - ax) * (cy - ay) - (by - ay) * (cx - ax);
  }

  static boolean overlap(long a, long b, long c, long d) {
    return Math.max(a, b) >= Math.min(c, d) &&
        Math.max(c, d) >= Math.min(a, b);
  }

  static boolean isIntersect(Line l1, Line l2) {
    long ab_c = ccw(l1.x1, l1.y1, l1.x2, l1.y2, l2.x1, l2.y1);
    long ab_d = ccw(l1.x1, l1.y1, l1.x2, l1.y2, l2.x2, l2.y2);
    long cd_a = ccw(l2.x1, l2.y1, l2.x2, l2.y2, l1.x1, l1.y1);
    long cd_b = ccw(l2.x1, l2.y1, l2.x2, l2.y2, l1.x2, l1.y2);

    if (ab_c * ab_d == 0 && cd_a * cd_b == 0) {
      return overlap(l1.x1, l1.x2, l2.x1, l2.x2) &&
          overlap(l1.y1, l1.y2, l2.y1, l2.y2);
    }

    return ab_c * ab_d <= 0 && cd_a * cd_b <= 0;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    Line[] lines = new Line[N];
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      long x1 = Long.parseLong(st.nextToken());
      long y1 = Long.parseLong(st.nextToken());
      long x2 = Long.parseLong(st.nextToken());
      long y2 = Long.parseLong(st.nextToken());
      lines[i] = new Line(x1, y1, x2, y2);
    }

    parent = new int[N];
    size = new int[N];

    for (int i = 0; i < N; i++) {
      parent[i] = i;
      size[i] = 1;
    }

    for (int i = 0; i < N; i++) {
      for (int j = i + 1; j < N; j++) {
        if (isIntersect(lines[i], lines[j])) {
          union(i, j);
        }
      }
    }

    int groupCount = 0;
    int maxSize = 0;

    for (int i = 0; i < N; i++) {
      if (parent[i] == i) {
        groupCount++;
        maxSize = Math.max(maxSize, size[i]);
      }
    }

    System.out.println(groupCount);
    System.out.println(maxSize);
  }
}
