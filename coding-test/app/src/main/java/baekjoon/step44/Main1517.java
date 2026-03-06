package baekjoon.step44;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1517 {

  static long count = 0;
  static long[] arr;
  static long[] temp;

  static void mergeSort(int left, int right) {

    if (left >= right) {
      return;
    }

    int mid = (left + right) / 2;

    mergeSort(left, mid);
    mergeSort(mid + 1, right);

    int i = left;
    int j = mid + 1;
    int k = left;

    while (i <= mid && j <= right) {

      if (arr[i] <= arr[j]) {
        temp[k++] = arr[i++];
      } else {
        temp[k++] = arr[j++];
        count += (mid - i + 1);
      }
    }

    while (i <= mid) {
      temp[k++] = arr[i++];
    }

    while (j <= right) {
      temp[k++] = arr[j++];
    }

    if (right + 1 - left >= 0)
      System.arraycopy(temp, left, arr, left, right + 1 - left);
  }

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    arr = new long[N];
    temp = new long[N];

    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < N; i++) {
      arr[i] = Long.parseLong(st.nextToken());
    }

    mergeSort(0, N - 1);

    System.out.println(count);
  }
}
