package baekjoon.step49;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2170 {

  static class Line implements Comparable<Line> {

    int s, e;

    Line(int s, int e) {
      this.s = s;
      this.e = e;
    }

    public int compareTo(Line o) {
      return this.s - o.s;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    Line[] arr = new Line[N];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      arr[i] = new Line(s, e);
    }

    Arrays.sort(arr);

    long answer = 0;

    int curS = arr[0].s;
    int curE = arr[0].e;

    for (int i = 1; i < N; i++) {
      if (arr[i].s <= curE) {
        curE = Math.max(curE, arr[i].e);
      } else {
        answer += curE - curS;
        curS = arr[i].s;
        curE = arr[i].e;
      }
    }

    answer += curE - curS;

    System.out.println(answer);
  }
}