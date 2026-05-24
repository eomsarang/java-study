package programmers;

import java.util.HashMap;

public class test14 {

  static class Solution {

    public String[] solution(String[] players, String[] callings) {

      HashMap<String, Integer> rank = new HashMap<>();

      for (int i = 0; i < players.length; i++) {
        rank.put(players[i], i);
      }

      for (String name : callings) {

        int now = rank.get(name);

        String frontPlayer = players[now - 1];

        players[now - 1] = name;
        players[now] = frontPlayer;
        
        rank.put(name, now - 1);
        rank.put(frontPlayer, now);
      }

      return players;
    }
  }
}