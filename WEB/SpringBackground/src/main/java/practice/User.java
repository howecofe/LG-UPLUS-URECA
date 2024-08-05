package practice;

public interface User {
    void register(String userId, String password);
    void remove(String userId, String password);
    void suspend(String userId);
}
