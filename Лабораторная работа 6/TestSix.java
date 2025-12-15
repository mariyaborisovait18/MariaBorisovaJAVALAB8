/**
 * Класс TestSix демонстрирует использование аннотации @Cache
 * с тремя областями кеширования: persons, products и orders.
 */
@Cache({"persons", "products", "orders"}) // Аннотация с тремя областями кеширования
public class TestSix {

}
