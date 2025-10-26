public class City {

    private String name;
    private City[] connectedCities;
    private int[] costs;
    private int routeCount;

    public String getName() {
        return this.name;
    }

    public int getRouteCount() {
        return this.routeCount;
    }

    public City getConnectedCity(int index) {
        return this.connectedCities[index];
    }

    public int getCost(int index) {
        return this.costs[index];
    }

    public City(String name) {
        this.name = name;
        this.connectedCities = new City[10];
        this.costs = new int[10];
        this.routeCount = 0;
    }

    /**
     * Добавляет маршрут в город с указанной стоимостью.
     * Максимальное количество маршрутов - 10.
     */
    public void addRoute(City city, int cost) {
        if (this.routeCount < 10) {
            this.connectedCities[this.routeCount] = city;
            this.costs[this.routeCount] = cost;
            ++this.routeCount;
        } else {
            System.out.println("Нельзя добавить больше маршрутов!");
        }
    }

    @Override
    public String toString() {
        String result = "Город '" + this.name + "'";
        if (this.routeCount == 0) {
            result = result + " - нет маршрутов в другие города";
        } else {
            result = result + " - (";
            for(int i = 0; i < this.routeCount; ++i) {
                if (i > 0) {
                    result = result + ", ";
                }
                result = result + this.connectedCities[i].getName() + ": " + this.costs[i];
            }
            result = result + ")";
        }
        return result;
    }
}

