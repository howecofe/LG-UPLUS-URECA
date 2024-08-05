package annotation.execTime;

public class Test {
    public static void main(String[] args) {
        MyClass mc = new MyClass();

        // 직접 메서드 호출
        mc.m();

        // Reflection 으로 객체의 annotation을 이용한 호출
        ExecTimeHandler.handleAnnotation(mc);
    }
}
