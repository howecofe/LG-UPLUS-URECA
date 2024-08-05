package annotation.aboutme;

import java.lang.annotation.Annotation;

// reflection을 이용해서 annotation 확인
public class Test {
    public static void main(String[] args) throws Exception {
        Class<?> myClass = Class.forName("annotation.aboutme.MyClass");
        System.out.println(myClass.getName());

        Annotation[] annotations = myClass.getDeclaredAnnotations();
        for(Annotation annotation : annotations) {
            if (annotation instanceof AboutMe) {
                AboutMe aboutMe = (AboutMe) annotation;
                System.out.println(aboutMe.love());
                System.out.println(aboutMe.hate());
            }

        }

    }
}
