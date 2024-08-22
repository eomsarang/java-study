package operator;

public class Test17 {
  public static void main(String[] args) {
    // 암시적 형변환 I
    // => 작은 메모리의 값은 큰 메모리에 저장할 수 있다.
    // => 단 정수끼리, 부동소수점끼리

    byte b1 = 100; // 리터럴인 경우 4바이트 크기를 갖더라도 변수에 저장할 수 있으면 허용한다.
    short s1 = 100; // 리터럴인 경우 4바이트 크기를 갖더라도 변수에 저장할 수 있으면 허용한다.
    char c1 = 100; // 리터럴인 경우 4바이트 크기를 갖더라도 변수에 저장할 수 있으면 허용한다.
    int i1 = 100;
    long l1 = 100;

    short s2 = b1;
    // char c2 = b1; // 컴파일 오류! char는 양수 0 ~ 65355 값을 저장할 수 있다. byte는 -128 ~ 127 값을 가진다.
    int i2 = b1;
    long l2 = b1;

    int i3 = s1;
    long l3 = s1;

    long l4 = i1;

    float f1 = 3.14f;
    double d1 = f1;
  }
}
