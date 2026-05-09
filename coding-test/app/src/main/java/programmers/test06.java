package programmers;

import java.util.Arrays;

public class test06 {

  static class Solution {

    public int solution(int[] mats, String[][] park) {
      Arrays.sort(mats);

      int n = park.length;
      int m = park[0].length;

      for (int k = mats.length - 1; k >= 0; k--) {
        int size = mats[k];

        for (int i = 0; i + size <= n; i++) {
          for (int j = 0; j + size <= m; j++) {
            boolean ok = true;

            for (int x = i; x < i + size && ok; x++) {
              for (int y = j; y < j + size; y++) {
                if (!park[x][y].equals("-1")) {
                  ok = false;
                  break;
                }
              }
            }

            if (ok) {
              return size;
            }
          }
        }
      }

      return -1;
    }
  }
}