package programmers.step01;

public class Main01 {

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.solution(new int[][]{{2, 1, 2}, {5, 1, 1}}));
  }
}

class Solution {

  public int solution(int[][] signals) {
    int n = signals.length;

    int[] T = new int[n];
    for (int i = 0; i < n; i++) {
      T[i] = signals[i][0] + signals[i][1] + signals[i][2];
    }

    long lcm = 1;
    for (int i = 0; i < n; i++) {
      lcm = lcm(lcm, T[i]);
      if (lcm > 1_000_000_000L) {
        break;
      }
    }

    for (long t = 1; t <= lcm; t++) {
      boolean ok = true;

      for (int i = 0; i < n; i++) {
        int G = signals[i][0];
        int Y = signals[i][1];
        int cycle = T[i];

        long mod = t % cycle;
        if (mod == 0) {
          mod = cycle;
        }

        if (!(mod > G && mod <= G + Y)) {
          ok = false;
          break;
        }
      }

      if (ok) {
        return (int) t;
      }
    }

    return -1;
  }

  long gcd(long a, long b) {
    return b == 0 ? a : gcd(b, a % b);
  }

  long lcm(long a, long b) {
    return a / gcd(a, b) * b;
  }
}