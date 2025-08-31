package baekjoon.step13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main18870 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int[] sorted = arr.clone();
    Arrays.sort(sorted);

    Map<Integer, Integer> map = new HashMap<>();
    int rank = 0;
    for (int num : sorted) {
      if (!map.containsKey(num)) {
        map.put(num, rank++);
      }
    }

    for (int i = 0; i < N; i++) {
      sb.append(map.get(arr[i])).append(" ");
    }

    System.out.println(sb);
  }
}
