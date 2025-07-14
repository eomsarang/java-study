// 정수 리터럴 범위
package study.lang.literal;

public class Exam06 {
  public static void main(String[] args){
    System.out.println(Integer.MIN_VALUE);
    System.out.println(Integer.MAX_VALUE);

    System.out.println(Long.MIN_VALUE);
    System.out.println(Long.MAX_VALUE);

    // 정수 리터럴을 작성할 때 메모리의 크기를 초과해서는 안된다.
    System.out.println(-2147483648); // 4바이트 메모리
    System.out.println(2147483647); // 4바이트 메모리
    System.out.println(-9223372036854775808L); // 8바이트 메모리
    System.out.println(9223372036854775807L); // 8바이트 메모리
  }
}
