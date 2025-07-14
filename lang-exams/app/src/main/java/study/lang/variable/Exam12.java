// 배열 레퍼런스와 배열 인스턴스
package study.lang.variable;

public class Exam12 {
  public static void main(String[] args){
    int[] arr1 = new int[] {100, 200, 300};

    // 레퍼런스에 저장된 것은 배열 인스턴스의 주소이다.
    // 그래서 언제든 그 주소를 다른 레퍼런스에 복사할 수 있다.
    int[] arr2 = arr1;

    arr2[1] = 222;
    System.out.println(arr1[1]);
  }
}
