package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class test13 {


  static class Solution {

    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {

      HashMap<String, Integer> map = new HashMap<>();

      map.put("code", 0);
      map.put("date", 1);
      map.put("maximum", 2);
      map.put("remain", 3);

      int extIndex = map.get(ext);
      int sortIndex = map.get(sort_by);

      List<int[]> list = new ArrayList<>();

      for (int[] d : data) {

        if (d[extIndex] < val_ext) {
          list.add(d);
        }
      }

      list.sort((a, b) -> a[sortIndex] - b[sortIndex]);

      int[][] answer = new int[list.size()][];

      for (int i = 0; i < list.size(); i++) {
        answer[i] = list.get(i);
      }

      return answer;
    }
  }
}