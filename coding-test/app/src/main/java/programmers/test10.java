package programmers;

import java.util.HashMap;

public class test10 {

  static class Solution {

    public int solution(String[] friends, String[] gifts) {

      int n = friends.length;

      HashMap<String, Integer> map = new HashMap<>();

      for (int i = 0; i < n; i++) {
        map.put(friends[i], i);
      }

      int[][] give = new int[n][n];

      int[] giftScore = new int[n];

      for (String g : gifts) {

        String[] temp = g.split(" ");

        int from = map.get(temp[0]);
        int to = map.get(temp[1]);

        give[from][to]++;

        giftScore[from]++;

        giftScore[to]--;
      }

      int[] nextGift = new int[n];

      for (int i = 0; i < n; i++) {

        for (int j = i + 1; j < n; j++) {

          int iToj = give[i][j];
          int jToi = give[j][i];

          if (iToj > jToi) {
            nextGift[i]++;
          } else if (jToi > iToj) {
            nextGift[j]++;
          } else {

            if (giftScore[i] > giftScore[j]) {
              nextGift[i]++;
            } else if (giftScore[j] > giftScore[i]) {
              nextGift[j]++;
            }
          }
        }
      }

      int answer = 0;

      for (int x : nextGift) {
        answer = Math.max(answer, x);
      }

      return answer;
    }
  }
}