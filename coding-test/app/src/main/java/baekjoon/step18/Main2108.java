package baekjoon.step18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main2108 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];
    int[] freq = new int[8001];

    int sum = 0;
    int min = 4001;
    int max = -4001;

    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(br.readLine());
      arr[i] = num;
      sum += num;
      freq[num + 4000]++;

      if (num < min) {
        min = num;
      }
      if (num > max) {
        max = num;
      }
    }

    Arrays.sort(arr);

    int mean = (int) Math.round((double) sum / N);
    sb.append(mean).append("\n");

    sb.append(arr[N / 2]).append("\n");

    int maxFreq = 0;
    for (int f : freq) {
      if (f > maxFreq) {
        maxFreq = f;
      }
    }

    List<Integer> modeCandidates = new ArrayList<>();
    for (int i = 0; i < freq.length; i++) {
      if (freq[i] == maxFreq) {
        modeCandidates.add(i - 4000);
      }
    }

    int mode;
    if (modeCandidates.size() == 1) {
      mode = modeCandidates.get(0);
    } else {
      Collections.sort(modeCandidates);
      mode = modeCandidates.get(1);
    }
    sb.append(mode).append("\n");

    sb.append(max - min).append("\n");

    System.out.print(sb);
  }
}
