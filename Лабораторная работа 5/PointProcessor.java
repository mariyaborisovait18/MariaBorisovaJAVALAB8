import point.Point;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class PointProcessor {
    // Приватные свойства
    private List<Point> originalPoints;
    private List<Point> processedPoints;
    private Polyline resultPolyline;

    /**
     * Создает процессор для списка точек
     * @param points список точек для обработки
     */
    public PointProcessor(List<Point> points) {
        this.originalPoints = points;
        this.processedPoints = new ArrayList<>();
        this.resultPolyline = new Polyline();
    }

    /**
     * Создает пустой процессор точек
     */
    public PointProcessor() {
        this.originalPoints = new ArrayList<>();
        this.processedPoints = new ArrayList<>();
        this.resultPolyline = new Polyline();
    }

    /**
     * @return исходный список точек
     */
    public List<Point> getOriginalPoints() {
        return originalPoints;
    }

    /**
     * @return обработанный список точек
     */
    public List<Point> getProcessedPoints() {
        return processedPoints;
    }

    /**
     * @return результирующую ломаную линию
     */
    public Polyline getResultPolyline() {
        return resultPolyline;
    }

    /**
     * Добавляет точку в исходный список
     * @param point точка для добавления
     */
    public void addPoint(Point point) {
        this.originalPoints.add(point);
    }

    /**
     * Добавляет точку в исходный список по координатам
     * @param x координата X
     * @param y координата Y
     */
    public void addPoint(double x, double y) {
        this.originalPoints.add(new Point(x, y));
    }

    /**
     * Обрабатывает точки: удаляет дубликаты, сортирует по X и делает Y положительными
     */
    public void processPoints() {
        // Стрим обработка
        this.processedPoints = originalPoints.stream()
                // Убираем точки с одинаковыми X,Y
                .distinct()
                // Сортируем по X
                .sorted((p1, p2) -> Double.compare(p1.getX(), p2.getX()))
                // Отрицательные Y делаем положительными
                .map(p -> {
                    if (p.getY() < 0) {
                        return new Point(p.getX(), Math.abs(p.getY()));
                    }
                    return p;
                })
                // Собираем в список
                .collect(Collectors.toList());

        // Создаем ломаную из обработанных точек
        this.resultPolyline = new Polyline(processedPoints);
    }

    /**
     * @return строковое представление процессора точек
     */
    public String toString() {
        return  "PointProcessor: " +
                "Исходные точки: " + originalPoints + "\n" +
                "Обработанные точки: " + processedPoints + "\n" +
                "Результирующая ломаная: " + resultPolyline.toString();
    }
}