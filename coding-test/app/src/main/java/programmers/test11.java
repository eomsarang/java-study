package programmers;

public class test11 {

  static class Solution {

    public int solution(int[] bandage, int health, int[][] attacks) {

      int t = bandage[0];
      int x = bandage[1];
      int y = bandage[2];

      int maxHealth = health;
      int combo = 0;

      int attackIndex = 0;

      for (int time = 1; time <= attacks[attacks.length - 1][0]; time++) {

        if (time == attacks[attackIndex][0]) {

          health -= attacks[attackIndex][1];

          if (health <= 0) {
            return -1;
          }

          combo = 0;

          attackIndex++;
        } else {

          combo++;

          health += x;

          if (combo == t) {
            health += y;
            combo = 0;
          }

          if (health > maxHealth) {
            health = maxHealth;
          }
        }
      }

      return health;
    }
  }
}