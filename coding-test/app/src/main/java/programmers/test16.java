package programmers;

public class test16 {

  static class Solution {

    public int[] solution(String[] park, String[] routes) {

      int h = park.length;
      int w = park[0].length();

      int x = 0;
      int y = 0;

      for (int i = 0; i < h; i++) {
        for (int j = 0; j < w; j++) {
          if (park[i].charAt(j) == 'S') {
            x = i;
            y = j;
          }
        }
      }

      for (String route : routes) {

        String[] temp = route.split(" ");

        char dir = temp[0].charAt(0);
        int dist = Integer.parseInt(temp[1]);

        int nx = x;
        int ny = y;

        boolean possible = true;

        for (int i = 0; i < dist; i++) {

          if (dir == 'N') {
            nx--;
          } else if (dir == 'S') {
            nx++;
          } else if (dir == 'W') {
            ny--;
          } else if (dir == 'E') {
            ny++;
          }

          if (nx < 0 || ny < 0 || nx >= h || ny >= w) {
            possible = false;
            break;
          }

          if (park[nx].charAt(ny) == 'X') {
            possible = false;
            break;
          }
        }

        if (possible) {
          x = nx;
          y = ny;
        }
      }

      return new int[]{x, y};
    }
  }
}