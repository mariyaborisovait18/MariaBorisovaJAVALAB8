package cache;

/**
 * Класс cache.TestSix демонстрирует использование аннотации @cache.Cache
 * с тремя областями кеширования: persons, products и orders.
 */
@Cache({"persons", "products", "orders"})
public class TestSix {

}
