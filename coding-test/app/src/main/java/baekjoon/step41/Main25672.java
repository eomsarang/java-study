package baekjoon.step41;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main25672 {

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int t = Integer.parseInt(br.readLine());

    StringBuilder out = new StringBuilder();

    while (t-- > 0) {

      st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());

      TreeSet<Integer> set = new TreeSet<>();

      if (k > 0) {
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
          set.add(Integer.parseInt(st.nextToken()));
        }
      } else {
        br.readLine();
      }

      if (set.contains(1)) {
        set.remove(1);
      } else {
        set.add(1);
      }

      out.append(n).append(" ").append(set.size()).append("\n");

      if (!set.isEmpty()) {
        for (int x : set) {
          out.append(x).append(" ");
        }
        out.append("\n");
      } else {
        out.append("\n");
      }
    }

    System.out.print(out);
  }
}
