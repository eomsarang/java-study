package baekjoon.step42;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main14908 {

  static class Job {

    int idx;
    long t, s;

    Job(int idx, long t, long s) {
      this.idx = idx;
      this.t = t;
      this.s = s;
    }
  }

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    Job[] jobs = new Job[N];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      long T = Long.parseLong(st.nextToken());
      long S = Long.parseLong(st.nextToken());
      jobs[i] = new Job(i + 1, T, S);
    }

    Arrays.sort(jobs, (a, b) -> {
      long left = a.t * b.s;
      long right = b.t * a.s;

      if (left != right) {
        return Long.compare(left, right);
      }

      return a.idx - b.idx;
    });

    StringBuilder sb = new StringBuilder();
    for (Job j : jobs) {
      sb.append(j.idx).append(" ");
    }

    System.out.println(sb);
  }
}
