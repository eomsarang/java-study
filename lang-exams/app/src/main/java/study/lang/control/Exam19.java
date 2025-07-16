// 반복문: enhanced for - Iterable 객체
package study.lang.control;

import java.util.LinkedList;

public class Exam19 {

  // 중첩된 반복문
  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    list.add("홍길동");
    list.add("임꺽정");
    list.add("유관순");
    list.add("안중근");
    list.add("윤봉길");

    for (int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i));
    }
    System.out.println("------------------");

    for (Object value : list) {
      System.out.println(value);
    }
    
    // 위 enhanced for 문은 다음 문장으로 변경된다.
//    Iterator iterator = list.iterator();
//    while (iterator.hasNext()) {
//      Object value = iterator.next();
//      System.out.println(value);
//    }
  }
}
