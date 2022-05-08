import java.util.LinkedList;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LambdaTest {

    public static void main(String[] args) {
        Predicate<String> p = s -> s.equals("my string");
        System.out.println(p.test("my string"));
        System.out.println(p.negate().test("my string"));

        IntStream.of(2, 1, 3, 5, 4)
                .filter(i -> i % 2 == 0)
                .sorted()
                .forEach(System.out::println);

        System.out.println(IntStream.of(2, 1, 3, 5, 4)
                .summaryStatistics());

        double reduce = DoubleStream.of(2, 1, 3, 5, 4)
                .reduce(0, (a, b) -> a + Math.pow(b, 2));
        System.out.println("reduce " + reduce);

        Stream.of("mz", "skate")
                .filter(s -> s.length() < 5)
                .collect(Collectors.toSet())
//                .collect(Collectors.toCollection(LinkedList::new))
                .forEach(System.out::println);

        Stream.of("mz", "skate")
                .map(s -> s + "_concat")
                .forEach(System.out::println);

        test();
    }

    static void test() {
        int unchangedLocalVar = 3; // effectively final
        final int localVarFinal = 4; // final
        int simpleLocalVar = 0;
        //simpleLocalVar = 9; // updated the value
        new Thread(() -> {
            System.out.println(unchangedLocalVar); // can read
            System.out.println(localVarFinal); // can read
            System.out.println(simpleLocalVar); // compile error
        }).start();
    }
}
