import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

ArrayList<ArrayList<Integer>> reports = new ArrayList<>();

void parse(Path path) throws IOException {
    reports.clear();

    Scanner reportsSc = new Scanner(path);
    while (reportsSc.hasNextLine()) {
        ArrayList<Integer> report = new ArrayList<>();
        String line = reportsSc.nextLine();

        Scanner levelSc = new Scanner(line);

        while (levelSc.hasNextInt()) {
            int number = levelSc.nextInt();
            report.add(number);
        }

        if (report.getFirst() > report.getLast())  {
            Collections.reverse(report);
        };

        reports.add(report);
    }
}

Object part1() {
    int count = reports.size();
    for (ArrayList<Integer> level: reports) {
        // Remove report if more than one redundant levels
        if (new HashSet<>(level).size() + 1 < level.size()) {
            count--;
            continue;
        }

        for (int i = 0; i < level.size() - 1; i++) {
            if (!validDiff(i, i+ 1, level)) {
                count--;
                break;
            }
        }
    }
    return count;
}

Object part2() {
    int count = reports.size();
    int test = 0;
    for (ArrayList<Integer> level: reports) {
        test++;
        boolean skippedOnce = false;

        // Remove report if more than one redundant levels
        if (new HashSet<>(level).size() + 1 < level.size()) {
            count--;
            continue;
        }

        for (int i = 0; i < level.size() - 1; i++) {
            if (validDiff(i, i + 1, level)) {
                continue;
            }

            // Remove indices at invalid difference
            if (!skippedOnce && (i == level.size() - 2 || (validDiff(i, i + 2, level)))) {
                i++;
                skippedOnce = true;
                continue;
            }

            if (!skippedOnce && (i == 0 || validDiff(i - 1, i + 1, level))) {
                skippedOnce = true;
                continue;
            }

            count--;
            break;
        }
    }
    return count;
}

boolean validDiff(int left, int right, ArrayList<Integer> list) {
    int difference = list.get(right) - list.get(left);
    return difference >= 1 && difference <= 3;
}

Path path(String suffix) {
    return Path.of("inputs/input" + Integer.parseInt(getClass().getName().replaceAll("\\D", "")) + suffix);
}

void main() throws IOException {
    long start = System.nanoTime();
    parse(path("a"));
    System.out.println(part2());
    System.out.println(part1());
    parse(path("z"));
    System.out.println(part1());
    System.out.println(part2());
    System.out.println("%.3f sec".formatted((System.nanoTime() - start) / 1E9));
}