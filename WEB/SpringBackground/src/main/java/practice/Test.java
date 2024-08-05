package practice;

import practice.annotation.CheckNotNullInvocationHandler;

import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        // class instance
        User user = new UserImpl();

        // parameter
        String userId = "greta";
//        String password = "1234";
//        String userId = null;
        String password = null;

        User proxy = (User) Proxy.newProxyInstance(
                user.getClass().getClassLoader(),
                user.getClass().getInterfaces(),
                new CheckNotNullInvocationHandler(user)
        );

        proxy.register(userId, password);
        proxy.remove(userId, password);
        proxy.suspend(userId);
    }
}
