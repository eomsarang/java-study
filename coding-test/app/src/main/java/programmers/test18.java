package programmers;

public class test18 {

  static class Solution {

    public int solution(int n, int m, int[] section) {

      int count = 0;

      int painted = 0;

      for (int s : section) {

        if (s > painted) {

          count++;

          painted = s + m - 1;
        }
      }

      return count;
    }
  }
}