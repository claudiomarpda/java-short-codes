import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WatchDirTest {
    public static void main(String[] args) throws IOException {
        Set<String> strings = listFilesUsingFilesList("src/resources");
        strings.forEach(System.out::println);

    }

    public static Set<String> listFilesUsingFilesList(String dir) throws IOException {
        Files.list(Paths.get(dir))
                .filter(file -> !Files.isDirectory(file))
                .forEach(System.out::println);

        try (Stream<Path> stream = Files.list(Paths.get(dir))) {
            return stream
                    .filter(file -> !Files.isDirectory(file))
                    .map(Path::toString)
                    .collect(Collectors.toSet());
        }
    }
}
