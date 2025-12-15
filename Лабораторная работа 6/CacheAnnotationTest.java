import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Класс CacheAnnotationTest содержит тесты для проверки работы аннотации @Cache
 * и класса CacheHandler.
 */
public class CacheAnnotationTest {

    /**
     * Проверяет, что список кешируемых областей корректно считывается у класса TestSix.
     */
    @Test
    void testCacheAnnotationOnTestSix() {
        Cache annotation = TestSix.class.getAnnotation(Cache.class);
        assertNotNull(annotation, "Аннотация @Cache должна быть на классе TestSix");
        String[] values = annotation.value();
        assertArrayEquals(new String[]{"persons", "products", "orders"}, values,
                "Список кешируемых областей должен совпадать");
    }

    /**
     * Проверяет, что пустой массив у класса CacheSixTwo означает отсутствие кешируемых областей.
     */
    @Test
    void testCacheAnnotationOnCacheSixTwo() {
        Cache annotation = CacheSixTwo.class.getAnnotation(Cache.class);
        assertNotNull(annotation, "Аннотация @Cache должна быть на классе CacheSixTwo");
        String[] values = annotation.value();
        assertEquals(0, values.length, "Список кешируемых областей должен быть пуст");
    }

    /**
     * Мок-тест: проверяет вызов метода processClass у CacheHandler.
     */
    @Test
    void testCacheHandlerWithMock() {
        CacheHandler handlerMock = Mockito.mock(CacheHandler.class);
        handlerMock.processClass(TestSix.class);
        Mockito.verify(handlerMock, Mockito.times(1)).processClass(TestSix.class);
    }

    /**
     * Проверяет наличие нескольких кешируемых областей у класса TestSix.
     */
    @Test
    void testMultipleCacheAreas() {
        Cache annotation = TestSix.class.getAnnotation(Cache.class);
        assertNotNull(annotation, "Аннотация @Cache должна быть на классе TestSix");
        String[] values = annotation.value();

        assertTrue(values.length > 1, "Должно быть несколько кешируемых областей");
        assertTrue(Arrays.asList(values).contains("persons"), "Список должен содержать 'persons'");
        assertTrue(Arrays.asList(values).contains("products"), "Список должен содержать 'products'");
        assertTrue(Arrays.asList(values).contains("orders"), "Список должен содержать 'orders'");
    }
}
