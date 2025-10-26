package baekjoon.step23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1931 {

  static class Meeting implements Comparable<Meeting> {

    int start, end;

    Meeting(int start, int end) {
      this.start = start;
      this.end = end;
    }

    @Override
    public int compareTo(Meeting o) {
      if (this.end == o.end) {
        return this.start - o.start;
      }
      return this.end - o.end;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    Meeting[] meetings = new Meeting[N];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      meetings[i] = new Meeting(start, end);
    }

    Arrays.sort(meetings);

    int count = 0;
    int lastEnd = 0;

    for (Meeting m : meetings) {
      if (m.start >= lastEnd) {
        count++;
        lastEnd = m.end;
      }
    }

    System.out.println(count);
  }
}
