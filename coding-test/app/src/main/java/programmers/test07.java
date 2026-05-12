package programmers;

public class test07 {

  static class Solution {

    public int solution(int[][] fish_info) {
      int count = 0;

      for (int[] fish : fish_info) {
        int year = fish[3];

        if (year == 2021) {
          count++;
        }
      }

      return count;
    }
  }
}