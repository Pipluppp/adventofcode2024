import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

ArrayList<Integer> a = new ArrayList<>();
ArrayList<Integer> b = new ArrayList<>();

void parse(Path path) throws IOException {
    a.clear();
    b.clear();

    Scanner sc = new Scanner(path);
    while (sc.hasNextInt()) {
        a.add(sc.nextInt());
        b.add(sc.nextInt());
    }
    Collections.sort(a);
    Collections.sort(b);
}

Object part1() {
    return IntStream.range(0, a.size())
            .map(i -> Math.abs(a.get(i) - b.get(i)))
            .sum();
}

Object part2() {
    int sum = 0;
    for (int i = 0 ; i < a.size(); i++) {
        int num = a.get(i);
        int count = Collections.frequency(b, a.get(i));
        sum += num * count;
    }

    return sum;
}

Path path(String suffix) {
    return Path.of("inputs/input" + Integer.parseInt(getClass().getName().replaceAll("\\D", "")) + suffix);
}

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