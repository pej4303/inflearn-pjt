package lang.clazz;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ClassMain {
    public static void main(String[] args) throws Exception {
        /**
         * class 조회
         */
        // 1. class에서 조회
        Class<String> c1 = String.class;
        // 2. 인스턴스에서 조회
        Class c2 = new String().getClass();
        // 3. 문자열로 조회
        Class c3 = Class.forName("java.lang.String");

        // 모든 필드 출력
//        Field[] fields = c1.getDeclaredFields();
//        for (Field field : fields) {
//            System.out.println("field = " + field.getType() + " / " + field.getName());
//        }
//        // 모든 메서드 출력
//        Method[] methods = c1.getMethods();
//        for (Method method : methods) {
//            System.out.println("method = " + method);
//        }
        // 상위 클래스 정보 출력
        String name = c1.getSuperclass().getName();
        System.out.println("상위 클래스 = " + name);

        Class[] interfaces =c1.getInterfaces();
        for (Class i : interfaces) {
            System.out.println("인터페이스 = " + i.getName());
        }

    }
}
