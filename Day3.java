import java.io.IOException;
import java.nio.file.Path;

String content;

void parse(Path path) throws IOException {
    content = Files.readString(path);
}

Object part1() {
    String regex = "mul\\((\\d+),(\\d+)\\)";
    var pattern = Pattern.compile(regex);
    var matcher = pattern.matcher(content);

    int sum = 0;
    while (matcher.find()) {
        sum += Integer.parseInt(matcher.group(1)) * Integer.parseInt(matcher.group(2));
    }
    return sum;
}

Object part2() {
    boolean valid = true;
    String regex = "mul\\((\\d+),(\\d+)\\)|do\\(\\)|don't\\(\\)";
    var pattern = Pattern.compile(regex);
    var matcher = pattern.matcher(content);

    int sum = 0;
    while (matcher.find()) {
        if (matcher.group().equals("do()")) {
            valid = true;
        } else if (matcher.group().equals("don't()")) {
            valid = false;
        } else {
            if (valid) {
                sum += Integer.parseInt(matcher.group(1)) * Integer.parseInt(matcher.group(2));
            }
        }
    }
    return sum;

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