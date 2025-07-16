// 반복문: enhanced for - Iterable 객체
package study.lang.control;

import java.util.Iterator;

public class Exam18 {

  // 중첩된 반복문
  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    list.add("홍길동");
    list.add("임꺽정");
    list.add("유관순");
    list.add("안중근");
    list.add("윤봉길");

    for (int i = 0; i < list.length; i++) {
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

  static class LinkedList implements Iterable {
    Node head;
    Node tail;
    int length;

    void add(Object value) {
      Node node = new Node();
      node.value = value;

      length++;

      if (head == null) {
        tail = head = node;
        return;
      }
      tail.next = node;
      tail = node;
    }

    Object get(int index) {
      Node cursor = head;
      for (int i = 0; cursor != null && i < index; i++) {
        // 커서를 다음 노드로 이동시킨다.
        cursor = cursor.next;
      }
      if (cursor != null) {
        return cursor.value;
      }
      return null;
    }

    @Override
    public Iterator iterator() {
      return new LinkedListIterator(this);
    }
  }

  static class Node {
    Object value;
    Node next;
  }

  // LinkedList에서 값을 한 개씩 꺼내는 일을 하는 클래스
  static class LinkedListIterator implements Iterator {
    LinkedList list;
    int index;

    public LinkedListIterator(LinkedList list) {
      this.list = list;
    }

    @Override
    public boolean hasNext() {
      return this.index < list.length;
    }

    @Override
    public Object next() {
      return this.list.get(this.index++);
    }
  }
}
