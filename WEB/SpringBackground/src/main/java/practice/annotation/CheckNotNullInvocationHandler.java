package practice.annotation;

import practice.annotation.CheckNotNull;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CheckNotNullInvocationHandler implements InvocationHandler {
    private Object target;
    public CheckNotNullInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // target method
        Method targetMethod = target.getClass().getMethod(method.getName(), method.getParameterTypes());

        // @CheckNotNull 붙은 메서드인지 확인
        if (targetMethod.isAnnotationPresent(CheckNotNull.class)) {
            return handleCheckNotNull(targetMethod, args);
        }

        // @CheckNotNull 붙지 않은 메서드인 경우
        return method.invoke(target, args);
    }

    private Object handleCheckNotNull(Method method, Object[] args) throws Throwable {
        CheckNotNull checkNotNull = method.getAnnotation(CheckNotNull.class);
        String[] parameterNames = checkNotNull.parameterNames();

        // parameter check not null
        for (int i = 0; i < args.length; i++) {
            if (args[i] == null) {
                throw new IllegalArgumentException("Parameter " + parameterNames[i] + " is null (should be notnull)");
            }
        }

        // 문제가 없으면
        return method.invoke(target, args);
    }
}
