package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

// Reflection API를 통해 클래스 객체를 생성하고 제어할 수 있다.
public class Test {

    public static void main(String[] args) throws Exception {
        Class<?> userClass = Class.forName("reflection.User");

        // class 이름
        System.out.println(userClass.getName()); // reflection.User

        // field
        Field[] fields = userClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName() + " / " + field.getType());
        }

        // method
        Method[] methods = userClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName() + " / " + method.getReturnType());
        }

        // constructor
        Constructor<?>[] constructors = userClass.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor.getName() + " / " + constructor.getParameterCount());
        }

        // Class의 객체 생성, 제어
        Constructor<?> constructor = userClass.getDeclaredConstructor(String.class, String.class); // String 파라미터 2개를 받는 생성자 가져옴
        Object obj = constructor.newInstance("홍길동", "1234"); // 객체 생성
        System.out.println(obj); // User{username='홍길동', password='1234'}

        // 객체의 field
        Field username = userClass.getDeclaredField("username");
        System.out.println(username);
        System.out.println(username.canAccess(obj)); // 생성된 객체의 필드에 접근 가능한지 여부: private field이면 false

        username.setAccessible(true);
        System.out.println(username.canAccess(obj)); // true

        // setter
        username.set(obj, "이길동");
        System.out.println(obj); // User{username='이길동', password='1234'}

        // 메소드 호출
        Method getPassword = userClass.getDeclaredMethod("getPassword");
        String password = (String) getPassword.invoke(obj);
        System.out.println(password); // 1234

        Method setPassword = userClass.getDeclaredMethod("setPassword", String.class); // method name, parameter type
        setPassword.invoke(obj, "5678");
        System.out.println(obj); // User{username='이길동', password='5678'}
    }
}
