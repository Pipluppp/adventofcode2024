# Advent of Code 2024

Javaaaaaa

Will copy the setup and template from https://github.com/cayhorstmann/adventofcode2024 since it looks clean,
but without the new weird Java 23 preview stuff.

Modified template:

```java
import java.io.IOException;
import java.nio.file.Path;

public class Day1 {
    void parse(Path path) throws IOException {
    }

    Object part1() {
        return null;
    }

    Object part2() {
        return null;
    }

    Path path(String suffix) { return Path.of("inputs/input" + Integer.parseInt(getClass().getName().replaceAll("\\D", "")) + suffix); }

    void main() throws IOException {
        long start = System.nanoTime();
        parse(path("a"));
        System.out.println(part1());
        System.out.println(part2());
        parse(path("z"));
        System.out.println(part1());
        System.out.println(part2());
        System.out.println("%.3f sec".formatted((System.nanoTime() - start) / 1E9));
    }

}

```