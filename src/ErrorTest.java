public class ErrorTest {

    public static void main(String[] args) {
        try {
            System.exit(0);
            throw new OutOfMemoryError();
        } catch (Error | Exception e) {
            System.out.println(e.getCause());
        } finally {
            System.out.println("finally");
        }
    }
}
