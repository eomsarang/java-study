package baekjoon.step51;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main25051 {

  static class Star {

    double angle;
    long val;

    Star(double a, long v) {
      angle = a;
      val = v;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    long[] x = new long[N];
    long[] y = new long[N];
    long[] s = new long[N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      x[i] = Long.parseLong(st.nextToken());
      y[i] = Long.parseLong(st.nextToken());
      s[i] = Long.parseLong(st.nextToken());
    }

    long[] P = new long[M];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; i++) {
      P[i] = Long.parseLong(st.nextToken());
    }

    long answer = Long.MIN_VALUE;

    for (long p : P) {

      ArrayList<Star> list = new ArrayList<>();

      for (int i = 0; i < N; i++) {
        long dist2 = x[i] * x[i] + y[i] * y[i];
        if (dist2 <= p) {
          double ang = Math.atan2(y[i], x[i]);
          list.add(new Star(ang, s[i]));
        }
      }

      int sz = list.size();
      if (sz == 0) {
        answer = Math.max(answer, -p);
        continue;
      }

      list.sort(Comparator.comparingDouble(o -> o.angle));

      Star[] arr = new Star[sz * 2];
      for (int i = 0; i < sz; i++) {
        arr[i] = list.get(i);
        arr[i + sz] = new Star(list.get(i).angle + 2 * Math.PI, list.get(i).val);
      }

      long sum = 0, maxSum = 0;
      int r = 0;

      for (int l = 0; l < sz; l++) {

        while (r < l + sz &&
            arr[r].angle - arr[l].angle <= Math.PI / 2 + 1e-12) {
          sum += arr[r].val;
          r++;
        }

        maxSum = Math.max(maxSum, sum);

        sum -= arr[l].val;
      }

      answer = Math.max(answer, maxSum - p);
    }

    System.out.println(answer);
  }
}