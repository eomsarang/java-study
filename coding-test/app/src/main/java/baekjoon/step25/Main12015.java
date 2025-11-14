package baekjoon.step25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main12015 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());

    int[] arr = new int[N];
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int[] lis = new int[N];
    int size = 0;

    for (int x : arr) {

      int pos = Arrays.binarySearch(lis, 0, size, x);

      if (pos < 0) {
        pos = -(pos + 1);
      }

      lis[pos] = x;

      if (pos == size) {
        size++;
      }
    }

    System.out.println(size);
  }
}
