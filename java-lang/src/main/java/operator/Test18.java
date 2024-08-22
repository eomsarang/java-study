package operator;

public class Test18 {
  public static void main(String[] args) {
    // 암시적 형변환 II
    // => 다른 타입으로 자동 형변환

    // byte, short, char ==> int ==> long ==> float ==> double
    byte b1 = 100;
    short s1 = 100;
    char c1 = 100;
    int i1 = 100;
    long l1 = 100;

    float f1;
    f1 = b1;
    f1 = s1;
    f1 = c1;
    f1 = i1; // 7자리가 넘어가는 정수이 경우 하위 자릿수의 값이 잘린다.
    f1 = l1; // 7자리가 넘어가는 정수이 경우 하위 자릿수의 값이 잘린다.

    f1 = 2147483647; // 앞뒤로 0을 제거한 후 유효자릿수는 7자리가 넘어가기 때문에 뒷자리가 잘린다.
    System.out.println(f1);

    f1 = 2147483000; // 앞뒤로 0을 제거한 후 유효자릿수는 7자리이기 때문에 잘리지 않는다.
    System.out.println(f1);

    f1 = 4147483000L;
    System.out.println(f1); // 앞뒤로 0을 제거한 후 유효자릿수는 7자리이기 때문에 잘리지 않는다.
  }
}
