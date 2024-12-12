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
