// Garbage와 Garbage Collector
package study.lang.variable;

public class Exam13 {
  public static void main(String[] args){
    int[] arr1 = new int[] {100, 200, 300};

    // 새 배열을 만들어 그 배열의 주소를 arr1에 저장하면,
    // 기존 배열의 주소를 잃어버린다.
    // 이렇게 주소를 잃어 버려 사용할 수 없는 객체를 "Garbage"라 부른다.
    arr1 = new int[2];

    // Garbage는 언제 해제되는가?
    // - 메모리가 부족할 때 Garbage Collector가 해제시킨다.

    // null을 사용하여 레퍼런스를 초기화시킬 수 있다.
    arr1 = null; // 객체를 가리키지 않는 것을 의미한다. 실제로는 레퍼런스 메모리를 0으로 설정하는 것이다.
  }
}
