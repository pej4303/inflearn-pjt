package section07_set.test;

import java.util.Objects;

public class Rectangle {
    private int width;
    private int height;
    // 코드 작성

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        // 자바의 패턴 매칭 instanceof 문법, 자바 16부터 사용 가능
//        if (!(o instanceof Rectangle rectangle)) {
//            return false;
//        }

        if (!(o instanceof Rectangle)) {
            return false;
        }

        Rectangle rectangle = (Rectangle) o;

        return this.width == rectangle.width && this.height == rectangle.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }
}