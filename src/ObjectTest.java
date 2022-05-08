import java.util.Objects;

public class ObjectTest {

    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new A();
        System.out.println(a1.equals(a2));
    }

    static class A {
        int a;
        int b;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            A a1 = (A) o;
            return a == a1.a;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }
    }

}
