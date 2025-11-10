import point.Point;

public class Line {
    // Приватные свойства (инкапсуляция)
    private Point start;
    private Point end;

    /**
     * Создает линию от (0,0) до (0,0)
     */
    public Line() {
        this.start = new Point();
        this.end = new Point();
    }

    /**
     * Создает линию между двумя точками
     * @param start начальная точка
     * @param end конечная точка
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * Создает линию по координатам точек
     * @param startX X начальной точки
     * @param startY Y начальной точки
     * @param endX X конечной точки
     * @param endY Y конечной точки
     */
    public Line(double startX, double startY, double endX, double endY) {
        this.start = new Point(startX, startY);
        this.end = new Point(endX, endY);
    }

    /**
     * @return начальную точку линии
     */
    public Point getStart() {
        return start;
    }

    /**
     * @return конечную точку линии
     */
    public Point getEnd() {
        return end;
    }

    /**
     * Устанавливает новую начальную точку
     * @param start новая начальная точка
     */
    public void setStart(Point start) {
        this.start = start;
    }

    /**
     * Устанавливает новую конечную точку
     * @param end новая конечная точка
     */
    public void setEnd(Point end) {
        this.end = end;
    }

    /**
     * @return строковое представление линии
     */
    public String toString() {
        return "Линия от " + start.toString() + " до " + end.toString();
    }
}