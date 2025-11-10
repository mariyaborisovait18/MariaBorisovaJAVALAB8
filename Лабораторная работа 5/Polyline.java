import point.Point;

import java.util.ArrayList;
import java.util.List;

public class Polyline {
    private List<Point> points;

    /**
     * Создает пустую ломаную линию
     */
    public Polyline() {
        this.points = new ArrayList<>();
    }

    /**
     * Создает ломаную линию из списка точек
     * @param points список точек ломаной
     */
    public Polyline(List<Point> points) {
        this.points = points;
    }

    /**
     * @return список точек ломаной линии
     */
    public List<Point> getPoints() {
        return points;
    }

    /**
     * Добавляет точку в ломаную линию
     * @param point точка для добавления
     */
    public void addPoint(Point point) {
        this.points.add(point);
    }

    /**
     * Добавляет точку в ломаную линию по координатам
     * @param x координата X
     * @param y координата Y
     */
    public void addPoint(double x, double y) {
        this.points.add(new Point(x, y));
    }

    /**
     * @return строковое представление ломаной линии
     */
    public String toString() {
        if (points.isEmpty()) {
            return "Линия ()";
        }

        StringBuilder sb = new StringBuilder("Линия (");
        for (int i = 0; i < points.size(); i++) {
            sb.append(points.get(i).toString());
            if (i < points.size() - 1) {
                sb.append(",");
            }
        }
        sb.append(")");
        return sb.toString();
    }
}