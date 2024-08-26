package operator;

public class Test52 {
  public static void main(String[] args) {
    // 비트 연산자 활용

    // 활용 전:
    boolean man, working, local;

    man = false;
    working = true;
    local = true;

    System.out.println(man ? "남자" : "여자");
    System.out.println(working ? "재직" : "실직");
    System.out.println(local ? "내국인" : "외국인");

    // 활용 후:
    int data = 0; // 00000000000000000000000000000000
    data |= 0; // 00000000000000000000000000000000 => 여자
    data |= 2; // 00000000000000000000000000000010 => 재직
    data |= 4; // 00000000000000000000000000000100 => 내국인
    System.out.println((data & 1) > 0 ? "남자" : "여자");
    System.out.println((data & 1) > 0 ? "재직" : "실직");
    System.out.println((data & 4) > 0 ? "내국인" : "외국인");

  }
}
