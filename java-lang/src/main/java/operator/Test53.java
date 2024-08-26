package operator;

public class Test53 {
  public static void main(String[] args) {
    // 비트 연산자 활용 II

    final int MAN = 1; // 0001
    final int WORKING = 2; // 0010
    final int LOCAL = 4; // 0100

    int data = WORKING | LOCAL; // data = 0010 | 0100

    System.out.println((data & MAN) == 0 ? "남자" : "여자");
    System.out.println((data & WORKING) == 0 ? "재직" : "실직");
    System.out.println((data & LOCAL) == 0 ? "내국인" : "외국인");

  }
}
