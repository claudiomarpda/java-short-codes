public class MethodTest {

    public static void main(String[] args) {
        System.out.println(MethodTest.class.getModifiers());
    }

    // String[] strings = {"a", "b"};
    // argsTest(strings);
    static void argsTest(String ... args) {
        System.out.println(args[1]);
        for (String arg : args) {
            System.out.println(arg);
        }
    }

    private static void go() {
        Thread t = new Thread();

    }
}
