// 변수 사용 범위
package study.lang.variable;

public class Exam05 {
  public static void main(String[] args){
    int i = 100;

    // 블록 안에 선언된 변수는 블록 실행을 마치면 제거된다.
    {
      int j = 200;
      System.out.println(i); // 바깥 블록의 변수를 사용할 수 있다.
      System.out.println(j);
      i = 110;
      j = 210;
    }
    System.out.println(i);
    // System.out.println(j); // 블록이 끝나면 그 블록에서 선언한 변수는 제거된다.

  }
}
