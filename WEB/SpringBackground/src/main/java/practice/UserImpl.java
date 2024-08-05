package practice;

import practice.annotation.CheckNotNull;

public class UserImpl implements User {

    @Override
    @CheckNotNull(parameterNames = {"userId", "password"})
    public void register(String userId, String password) {
        System.out.println("register(): userId = " + userId + ", password = " + password);
    }

    @Override
    @CheckNotNull(parameterNames = {"userId", "password"})
    public void remove(String userId, String password) {
        System.out.println("remove(): userId = " + userId + ", password = " + password);
    }

    @Override
    @CheckNotNull(parameterNames = {"userId"})
    public void suspend(String userId) {
        System.out.println("suspend(): userId = " + userId);
    }
}
