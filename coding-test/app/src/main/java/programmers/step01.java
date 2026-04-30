package programmers;

public class step01 {

  class Solution {

    public int solution(int n, int w, int num) {

      // 1. 현재 위치
      int row = (num - 1) / w;
      int col = (num - 1) % w;

      if (row % 2 == 1) {
        col = w - 1 - col;
      }

      int answer = 1; // 자기 자신 포함

      int totalRows = (n + w - 1) / w;

      // 2. 위쪽 줄 탐색
      for (int r = row + 1; r < totalRows; r++) {

        int cnt = w;
        // 마지막 줄이면 개수 줄어듦
        if (r == totalRows - 1) {
          cnt = n - r * w;
        }

        int checkCol = col;
        if (r % 2 == 1) {
          checkCol = w - 1 - col;
        }

        if (checkCol < cnt) {
          answer++;
        }
      }

      return answer;
    }
  }
}
