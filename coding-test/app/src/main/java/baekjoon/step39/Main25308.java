package baekjoon.step39;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main25308 {

  static boolean nextPermutation(int[] a) {
    int i = a.length - 1;
    while (i > 0 && a[i - 1] >= a[i]) {
      i--;
    }
    if (i == 0) {
      return false;
    }

    int j = a.length - 1;
    while (a[i - 1] >= a[j]) {
      j--;
    }

    int tmp = a[i - 1];
    a[i - 1] = a[j];
    a[j] = tmp;

    for (int l = i, r = a.length - 1; l < r; l++, r--) {
      tmp = a[l];
      a[l] = a[r];
      a[r] = tmp;
    }
    return true;
  }

  static boolean isConvex(int[] a) {
    for (int k = 0; k < 8; k++) {
      int i = k;
      int j = (k + 1) % 8;
      int l = (k + 2) % 8;

      long ai = a[i];
      long aj = a[j];
      long al = a[l];

      if (ai * ai + al * al < 2L * aj * aj) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int[] a = new int[8];
    for (int i = 0; i < 8; i++) {
      a[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(a);

    long ans = 0;
    do {
      if (isConvex(a)) {
        ans++;
      }
    } while (nextPermutation(a));

    System.out.println(ans);
  }
}
