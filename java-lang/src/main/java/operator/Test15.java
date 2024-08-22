package operator;

public class Test15 {
  public static void main(String[] args) {
    // 명시적 형변환 II
    // float f1 = 3.14; // 컴파일 오류!
    // 3.14는 8바이트 크기를 갖는 double형 리터럴이다.
    // 따라서 4바이트 크기를 갖는 float형 임시 메모리에 저장할 수 없다.

    float f2 = 3.14f;
    float f3 = (float) 3.14; // double형 리터럴을 flaot 임시 메모리에 저장한 후 f3에 저장한다.

    double d1 = 3.14;
    float f4 = (float) d1; // double형 변수의 값을 float 임시 메모리에 저장한 후 f4에 저장한다.
    System.out.printf("%f, %f, %f\n", f2, f3, f4);

    // 형변환 할 때,
    // 큰 메모리의 값을 작은 메모리에 저장할 수 없을 경우 값이 잘리거나 반올림 처리된다.
    double d2 = 3.1415926535;
    float f5 = (float) d2;
    System.out.println(f5);
  }
}
