package baekjoon.step49;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main2836 {

  static class Line implements Comparable<Line> {

    long s, e;

    Line(long s, long e) {
      this.s = s;
      this.e = e;
    }

    public int compareTo(Line o) {
      if (this.s == o.s) {
        return Long.compare(this.e, o.e);
      }
      return Long.compare(this.s, o.s);
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    long M = Long.parseLong(st.nextToken());

    ArrayList<Line> list = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      long a = Long.parseLong(st.nextToken());
      long b = Long.parseLong(st.nextToken());

      if (a > b) {
        list.add(new Line(b, a));
      }
    }

    if (list.isEmpty()) {
      System.out.println(M);
      return;
    }

    Collections.sort(list);

    long sum = 0;

    long curS = list.get(0).s;
    long curE = list.get(0).e;

    for (int i = 1; i < list.size(); i++) {
      Line now = list.get(i);

      if (now.s <= curE) {
        curE = Math.max(curE, now.e);
      } else {
        sum += (curE - curS);
        curS = now.s;
        curE = now.e;
      }
    }

    sum += (curE - curS);

    System.out.println(M + 2 * sum);
  }
}