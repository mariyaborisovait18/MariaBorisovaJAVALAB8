package point;

public class Point {
    // Приватные свойства (инкапсуляция)
    private double x;
    private double y;

    /**
     * Создает точку в начале координат (0,0)
     */
    public Point() {
        this.x = 0;
        this.y = 0;
    }

    /**
     * Создает точку с указанными координатами
     * @param x координата X
     * @param y координата Y
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return координату X точки
     */
    public double getX() {
        return x;
    }

    /**
     * @return координату Y точки
     */
    public double getY() {
        return y;
    }

    /**
     * Устанавливает новую координату X
     * @param x новая координата X
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Устанавливает новую координату Y
     * @param y новая координата Y
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * @return строковое представление точки в формате {x;y}
     */
    public String toString() {
        return "{" + x + ";" + y + "}";
    }
}