package baekjoon.step42;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main12776 {

  static class Drive {

    long a, b;

    Drive(long a, long b) {
      this.a = a;
      this.b = b;
    }
  }

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    ArrayList<Drive> gain = new ArrayList<>();
    ArrayList<Drive> loss = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      long a = Long.parseLong(st.nextToken());
      long b = Long.parseLong(st.nextToken());

      if (b >= a) {
        gain.add(new Drive(a, b));
      } else {
        loss.add(new Drive(a, b));
      }
    }

    gain.sort(Comparator.comparingLong(d -> d.a));

    loss.sort((d1, d2) -> Long.compare(d2.b, d1.b));

    long free = 0;
    long extra = 0;

    for (Drive d : gain) {
      if (free < d.a) {
        extra += (d.a - free);
        free = d.a;
      }
      free += (d.b - d.a);
    }

    for (Drive d : loss) {
      if (free < d.a) {
        extra += (d.a - free);
        free = d.a;
      }
      free += (d.b - d.a);
    }

    System.out.println(extra);
  }
}
