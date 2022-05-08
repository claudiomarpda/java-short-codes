import java.util.HashSet;

public class HashSetTest {

    static class A {
        int id;
        String a;

        public A(int id, String a) {
            this.id = id;
            this.a = a;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            } else if (!(obj instanceof A)) {
                return false;
            } else {
                return a.equals(((A) obj).a);
            }
        }

        @Override
        public int hashCode() {
            return id;
        }
    }

    public static void main(String[] args) {
        HashSet<A> hashSet = new HashSet<>();
        hashSet.add(new A(1, "1"));
        hashSet.add(new A(2, "2"));
        System.out.println(hashSet.size());

    }
}
