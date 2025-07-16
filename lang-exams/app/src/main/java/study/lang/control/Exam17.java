// 반복문: enhanced for - 배열
package study.lang.control;

public class Exam17 {

  // 중첩된 반복문
  public static void main(String[] args) {
    // for (변수 선언: 배열 / Iterable 객체) 문장;
    // - 배열을 처음부터 끝까지 반복할 때 유용하다.
    // - 인덱스를 활용하지 않고 값만 꺼낼 때 유용하다.
    String[] names = {"홍길동", "임꺽정", "유관순", "안중근", "윤봉길"};

    for (String name: names) {
      System.out.println(name);
    }

  }
}
