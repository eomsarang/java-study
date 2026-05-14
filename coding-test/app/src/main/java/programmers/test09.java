package programmers;

import java.util.Arrays;

public class test09 {


  static class Solution {

    public int solution(int[] mats, String[][] park) {

      Arrays.sort(mats);

      int rows = park.length;
      int cols = park[0].length;

      for (int m = mats.length - 1; m >= 0; m--) {

        int size = mats[m];

        for (int i = 0; i <= rows - size; i++) {
          for (int j = 0; j <= cols - size; j++) {

            boolean possible = true;

            for (int x = i; x < i + size; x++) {
              for (int y = j; y < j + size; y++) {

                if (!park[x][y].equals("-1")) {
                  possible = false;
                  break;
                }
              }

              if (!possible) {
                break;
              }
            }

            if (possible) {
              return size;
            }
          }
        }
      }

      return -1;
    }
  }
}