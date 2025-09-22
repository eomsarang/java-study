package baekjoon.step19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main24060 {

  static int[] A, tmp;
  static int K, count = 0, result = -1;

  public static void mergeSort(int p, int r) {
    if (p < r) {
      int q = (p + r) / 2;
      mergeSort(p, q);
      mergeSort(q + 1, r);
      merge(p, q, r);
    }
  }

  public static void merge(int p, int q, int r) {
    int i = p, j = q + 1, t = 0;

    while (i <= q && j <= r) {
      if (A[i] <= A[j]) {
        tmp[t++] = A[i++];
      } else {
        tmp[t++] = A[j++];
      }
    }
    while (i <= q) {
      tmp[t++] = A[i++];
    }
    while (j <= r) {
      tmp[t++] = A[j++];
    }

    i = p;
    t = 0;
    while (i <= r) {
      A[i] = tmp[t];
      count++;
      if (count == K) {
        result = A[i];
        return;
      }
      i++;
      t++;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    A = new int[N];
    tmp = new int[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }

    mergeSort(0, N - 1);

    System.out.println(result);
  }
}
