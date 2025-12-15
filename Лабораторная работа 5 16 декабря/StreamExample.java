import java.util.*;
import java.util.stream.Collectors;

public class StreamExample {

    public static Polyline buildPolyline(List<Point> input) {
        List<Point> processed = input.stream()
                .map(Point::normalizeY)                // отрицательные Y → положительные
                .distinct()                            // убрать одинаковые X,Y
                .sorted(Comparator.comparing(Point::getX)) // отсортировать по X
                .collect(Collectors.toList());

        return new Polyline(processed);
    }
}
