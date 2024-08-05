package annotation.encrypt;

public class Test {
    public static void main(String[] args) {
        User user = new User("홍길동", "1234");

        System.out.println(user); // User{username='홍길동', password='1234'}

        // reflection 을 이용한 @Encrypt 필드에 대한 암호화 처리
        EncryptHandler.handleAnnotation(user);

        System.out.println(user); // User{username='홍길동', password='MTIzNA=='}
    }
}
